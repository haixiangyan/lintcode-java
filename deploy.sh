#!/usr/bin/env sh

set -e

npm run docs:build

cd docs/.vuepress/dist

# echo 'www.example.com' > CNAME

git init
git add -A
git commit -m 'deploy'

git push -f https://github.com/Haixiang6123/lintcode.git master:gh-pages

cd -