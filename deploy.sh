#!/bin/bash
set -e # exit with nonzero exit code if anything fails

# Add deploy key
openssl aes-256-cbc -K $encrypted_4b0103a8caa4_key -iv $encrypted_4b0103a8caa4_iv -in .travisdeploykey.enc -out .travisdeploykey -d
chmod go-rwx .travisdeploykey
eval `ssh-agent -s`
ssh-add .travisdeploykey

sbt makeSite

# go to the out directory and create a *new* Git repo
cd target/site
git init

# inside this git repo we'll pretend to be a new user
git config user.name "Travis CI"
git config user.email "travis@payalabs.com"

# The first and only commit to this new Git repo contains all the
# files present with the commit message "Deploy to GitHub Pages".
git add .
git commit -m "Deploy to GitHub Pages"

# Force push from the current repo's master branch to the remote
# repo's gh-pages branch. (All previous history on the gh-pages branch
# will be lost, since we are overwriting it.) We redirect any output to
# /dev/null to hide any sensitive credential data that might otherwise be exposed.
git push --force --quiet "git@github.com:payalabs/scalajs-react-mdl.git" master:gh-pages > /dev/null 2>&1
