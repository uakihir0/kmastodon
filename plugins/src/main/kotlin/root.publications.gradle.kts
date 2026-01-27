plugins {
    id("io.github.gradle-nexus.publish-plugin")
}

// For users registered in Sonatype after 24 Feb 2021
nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
        }
    }
}
