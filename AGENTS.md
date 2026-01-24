# Agent Documentation

## Overview

This repository is a Mastodon API client library for Kotlin Multiplatform. It provides REST API bindings for Mastodon and a streaming API module for real-time updates.

## Key Concepts

### Mastodon REST API Structure

Most REST API calls are made to versioned endpoints such as `/api/v1/*` or `/api/v2/*` and use JSON request/response bodies.

Common endpoint categories:

- `accounts/*` - Account and profile operations
- `statuses/*` - Status (post) creation and interactions
- `timelines/*` - Home/local/federated timelines
- `notifications/*` - Notifications
- `media/*` - Media uploads
- `search/*` - Search
- `apps/*` - App registration
- `oauth/*` - OAuth token exchange

### Authentication

Mastodon uses OAuth2 and bearer tokens:

1. Register an application via `POST /api/v1/apps`
2. Redirect users to `/oauth/authorize`
3. Exchange the authorization code for an access token at `/oauth/token`
4. Use the access token in the `Authorization: Bearer <token>` header

### Streaming API

Streaming uses WebSocket connections to:

- `/api/v1/streaming` (query parameters include `access_token` and `stream`)

Common stream types:

- `user` - User stream (home timeline + notifications)
- `public` - Public timeline
- `public:local` - Local timeline
- `hashtag` - Hashtag stream
- `direct` - Direct messages

## Directory Structure

- **`core/`**: REST API client library
  - `api/` - Resource interfaces
    - `request/` - Request objects
    - `response/` - Response objects
  - `entity/` - Data models (Status, Account, Notification, etc.)
  - `internal/` - Internal implementations
  - `util/` - Utilities (serialization, helpers)
- **`stream/`**: Streaming API (WebSocket)
- **`all/`**: Package containing all modules (for platform distribution)
- **`plugins/`**: Gradle build configuration
- **`docs/`**: Documentation
- **`tool/`**: Auxiliary tooling

## Testing

Run all core tests:

```shell
./gradlew :core:jvmTest
```

Run specific tests:

```shell
./gradlew :core:jvmTest --tests "work.socialhub.kmastodon.apis.OAuthTest"
./gradlew :core:jvmTest --tests "work.socialhub.kmastodon.apis.StatusesTest"
```

If network access is not available, verify successful build:

```shell
./gradlew jvmJar
```

If authentication credentials are required for tests, create `secrets.json` based on `secrets.json.default`.

## Implementation Guidelines

### Endpoint and Package Mapping

API endpoints correspond to resource interfaces and request/response objects:

- `GET /api/v1/timelines/home` → `TimelinesResource` + `TimelinesHomeTimelineRequest`
- `POST /api/v1/statuses` → `StatusesResource` + `StatusesPostStatusRequest`
- `POST /api/v1/media` → `MediasResource` + `MediasPostMediaRequest`

When implementing or updating APIs, refer to the official Mastodon method documentation: https://docs.joinmastodon.org/methods/

### Steps to Add a New API

1. Add or update request/response models in `core/src/commonMain/kotlin/work/socialhub/kmastodon/api/request/` and `.../response/`.
2. Add the method to the appropriate resource interface in `api/`.
3. Update internal implementations under `internal/`.
4. Add or update tests in `core/src/jvmTest/kotlin/`.

### Naming Conventions

| Type      | Naming Pattern                | Example                      |
| --------- | ----------------------------- | ---------------------------- |
| Request   | `{ActionName}Request`         | `StatusesPostStatusRequest`  |
| Response  | `{ActionName}Response`        | `StatusesPostStatusResponse` |
| Resource  | `{Category}Resource`          | `StatusesResource`           |
| Entity    | Singular form                 | `Status`, `Account`          |

### Serialization

All models use `kotlinx.serialization`. Keep request and response field names aligned with Mastodon API specifications.

## Key File References

| Purpose                  | File Path                                                                          |
| ------------------------ | ---------------------------------------------------------------------------------- |
| Main client interface    | `core/src/commonMain/kotlin/work/socialhub/kmastodon/Mastodon.kt`                   |
| Factory                  | `core/src/commonMain/kotlin/work/socialhub/kmastodon/MastodonFactory.kt`           |
| Resource interfaces      | `core/src/commonMain/kotlin/work/socialhub/kmastodon/api/`                         |
| Request/response models  | `core/src/commonMain/kotlin/work/socialhub/kmastodon/api/request/` and `.../response/` |
| Streaming API            | `stream/src/commonMain/kotlin/work/socialhub/kmastodon/stream/`                    |
