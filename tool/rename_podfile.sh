#!/usr/bin/env bash
cd "$(dirname "$0")" || exit
BASE_PATH=$(pwd)
BUILD_PATH=../all/build

# Make Repository
cd "$BASE_PATH" || exit
mkdir -p $BUILD_PATH/cocoapods/repository/debug
mkdir -p $BUILD_PATH/cocoapods/repository/release

# Copy Podspec
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/debug || exit
cp kmastodon.podspec ../../repository/kmastodon-debug.podspec
cd ../../repository/ || exit
sed -i -e "s|'kmastodon'|'kmastodon-debug'|g" kmastodon-debug.podspec
sed -i -e "s|'kmastodon.xcframework'|'debug/kmastodon.xcframework'|g" kmastodon-debug.podspec
rm *.podspec-e
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/release || exit
cp kmastodon.podspec ../../repository/kmastodon-release.podspec
cd ../../repository/ || exit
sed -i -e "s|'kmastodon'|'kmastodon-release'|g" kmastodon-release.podspec
sed -i -e "s|'kmastodon.xcframework'|'release/kmastodon.xcframework'|g" kmastodon-release.podspec
rm *.podspec-e

# Copy Framework
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/debug || exit
cp -r kmastodon.xcframework ../../repository/debug/kmastodon.xcframework
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/release || exit
cp -r kmastodon.xcframework ../../repository/release/kmastodon.xcframework

# Copy README
cd "$BASE_PATH" || exit
cd ../ || exit
cp ./LICENSE ./all/build/cocoapods/repository/LICENSE
cp ./docs/pods/README.md ./all/build/cocoapods/repository/README.md
cp ./docs/pods/README_ja.md ./all/build/cocoapods/repository/README_ja.md
