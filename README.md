> [日本語](./docs/README_ja.md)

# kmastodon

![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo.repsy.io%2Fmvn%2Fuakihir0%2Fpublic%2Fwork%2Fsocialhub%2Fkmastodon%2Fcore%2Fmaven-metadata.xml)

![badge][badge-js]
![badge][badge-jvm]
![badge][badge-ios]
![badge][badge-mac]

**This library is a Mastodon client library that supports [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html).**
It depends on [khttpclient] and internally uses Ktor Client.
Therefore, this library is available on Kotlin Multiplatform and platforms supported by Ktor Client.
The behavior on each platform depends on [khttpclient].

## Usage

Below is how to use it in Kotlin with Gradle on supported platforms.
**If you want to use it on Apple platforms, please refer to [kmastodon-cocoapods](https://github.com/uakihir0/kmastodon-cocoapods) or [kmastodon-spm](https://github.com/uakihir0/kmastodon-spm).**
**Also, for usage in JavaScript, please refer to [kmastodon.js](https://github.com/uakihir0/kmastodon.js).**
Please refer to the test code for how to use each API.

```kotlin:build.gradle.kts
repositories {
    mavenCentral()
+   maven { url = uri("https://repo.repsy.io/mvn/uakihir0/public") }
}

dependencies {
+   implementation("work.socialhub.kmastodon:core:0.0.1-SNAPSHOT")
+   implementation("work.socialhub.kmastodon:stream:0.0.1-SNAPSHOT")
}
```

### Authentication

First, create an application and request application information from the server.

```kotlin
val mastodon = MastodonFactory.instance({{HOST}})

val response = mastodon.apps().registerApplication(
    AppsRegisterApplicationRequest().also {
        it.name = {{APP_NAME}}
        it.website = {{APP_WEBSITE}}
        it.redirectUris = {{REDIRECT_URI}}
        it.scopes = "read write follow push"
    }
)

println(response.data.clientId)
println(response.data.clientSecret)
```

Next, request the URL for users to authenticate as follows.

```kotlin
val response = mastodon.oauth().authorizationUrl(
    OAuthAuthorizationUrlRequest().also {
        it.clientId = {{CLIENT_ID}}
        it.redirectUri = {{REDIRECT_URI}}
        it.scopes = "read write follow push"
    }
)

println(response.data)
```

After the user authenticates and is redirected, obtain the code from the redirected URL query and get the access token as follows.

```kotlin
val response = mastodon.oauth().issueAccessTokenWithAuthorizationCode(
    OAuthIssueAccessTokenWithAuthorizationCodeRequest().also {
        it.clientId = {{CLIENT_ID}}
        it.clientSecret = {{CLIENT_SECRET}}
        it.redirectUri = {{REDIRECT_URI}}
        it.code = "CODE"
    }
)

println(response.data.accessToken)
```

### Create Note

```kotlin
val mastodon = MastodonFactory.instance(
    {{HOST}}, {{ACCESS_TOKEN}}
)

mastodon.statuses().postStatus(
    StatusesPostStatusRequest().also {
        it.status = "Post from kmastodon! for test." + "\n" +
                "https://github.com/uakihir0/kmastodon"
    }
)
```

## License

MIT License

## Author

[Akihiro Urushihara](https://github.com/uakihir0)

[khttpclient]: https://github.com/uakihir0/khttpclient
[badge-android]: http://img.shields.io/badge/-android-6EDB8D.svg
[badge-android-native]: http://img.shields.io/badge/support-[AndroidNative]-6EDB8D.svg
[badge-wearos]: http://img.shields.io/badge/-wearos-8ECDA0.svg
[badge-jvm]: http://img.shields.io/badge/-jvm-DB413D.svg
[badge-js]: http://img.shields.io/badge/-js-F8DB5D.svg
[badge-js-ir]: https://img.shields.io/badge/support-[IR]-AAC4E0.svg
[badge-nodejs]: https://img.shields.io/badge/-nodejs-68a063.svg
[badge-linux]: http://img.shields.io/badge/-linux-2D3F6C.svg
[badge-windows]: http://img.shields.io/badge/-windows-4D76CD.svg
[badge-wasm]: https://img.shields.io/badge/-wasm-624FE8.svg
[badge-apple-silicon]: http://img.shields.io/badge/support-[AppleSilicon]-43BBFF.svg
[badge-ios]: http://img.shields.io/badge/-ios-CDCDCD.svg
[badge-mac]: http://img.shields.io/badge/-macos-111111.svg
[badge-watchos]: http://img.shields.io/badge/-watchos-C0C0C0.svg
[badge-tvos]: http://img.shields.io/badge/-tvos-808080.svg