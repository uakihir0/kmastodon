> [日本語](./README_ja.md)

# kmastodon cocoapods

This repository is the Cocoapods repository for [kmastodon]. [kmastodon] is a Mastodon client library created using Kotlin Multiplatform.
Therefore, it can be built and used on Apple devices such as iOS. Here, we distribute the built XCFramework via Cocoapods.
Additionally, this repository is automatically committed by GitHub Actions for [kmastodon]. Please submit issues or pull requests to [kmastodon].

## Usage

### Podfile

Please add the following lines to your Podfile.
There are no versions in this repository, and there are branches that match the versions of [kmastodon].
You can determine which version of [kmastodon] to use by specifying the branch of this repository.
Please check the [branch list](https://github.com/uakihir0/kmastodon-cocoapods/branches) to find the branch corresponding to the version.
Additionally, different versions are used for Debug and Release builds.

```ruby
target '{{PROJECT_NAME}}' do
  use_frameworks!

  # Pods for kmastodon
  pod 'kmastodon-debug', 
    :configuration => ['Debug'], 
    :git => 'https://github.com/uakihir0/kmastodon-cocoapods/', 
    :branch => '{{BRANCH_NAME}}'
  pod 'kmastodon-release', 
    :configuration => ['Release'], 
    :git => 'https://github.com/uakihir0/kmastodon-cocoapods/', 
    :branch => '{{BRANCH_NAME}}'
  ...
end
```

### Requesting

It is also possible to use in Objective-C, but the following is the usage in Swift.
Please also check the README of [kmastodon] for detailed usage.

```swift
WIP
```

## License

MIT License

## Author

[Akihiro Urushihara](https://github.com/uakihir0)


[kmastodon]: https://github.com/uakihir0/kmastodon