# kmastodon cocoapods

本レポジトリは、[kmastodon] の Cocoapods レポジトリです。[kmastodon] は Kotlin Multiplatform を用いて作成された Mastodon クライアントライブラリです。
そのため、iOS 等の Apple Device でも使用でもビルドして使用することができます。ここでは、XCFramework としてビルドしたものを Cocoapods 経由で配布しています。
また、このレポジトリは [kmastodon] の GitHub Actions によって自動コミットされています。issue や pull request は [kmastodon] にお願いします。

## 使用方法

### Podfile

Podfile に以下のように記載してください。
本レポジトリにはバージョンは存在せず、[kmastodon] のバージョンと一致するブランチが存在します。
どのバージョンの [kmastodon] を使用するかは、本レポジトリのブランチを指定することで決定します。
[ブランチ一覧](https://github.com/uakihir0/kmastodon-cocoapods/branches) からバージョンに対応するブランチを確認してください。
また、Debug ビルドと Release ビルドでは異なるものを使用しています。

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

### リクエスト方法

Objective-C でも使用可能ですが、以下に Swift での使用方法を記載します。
詳しい使い方については、[kmastodon] の README も合わせて確認してください。

```swift
WIP
```

## ライセンス

MIT License

## 作者

[Akihiro Urushihara](https://github.com/uakihir0)


[kmastodon]: https://github.com/uakihir0/kmastodon