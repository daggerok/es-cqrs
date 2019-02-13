# ES / CQRS [![Build Status](https://travis-ci.org/daggerok/es-cqrs.svg?branch=master)](https://travis-ci.org/daggerok/es-cqrs)
You will not find anything interesting here ...believe me

_build everything_

```bash
./mvnw
```

_deploy into local `target/.m2/repository` maven repo_

```bash
./mvnw -P local-deploy
```

_publish release to github_

```bash
./mvnw -P create-github-release -pl :es-cqrs
```

_push github maven repository_

```bash
./mvnw -P github-maven-repository -pl :es-cqrs
```

_using github maven branch as maven repository_

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <!-- ... -->
  <repositories>
    <repository>
      <id>daggerok-es-cqrs-github-maven-repo</id>
      <url>https://raw.githubusercontent.com/daggerok/es-cqrs/maven/</url>
      <snapshots>
        <enabled>true</enabled>
        <updatePolicy>always</updatePolicy><!-- rly? attention! -->
      </snapshots>
    </repository>
  </repositories>
  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>com.github.daggerok.es</groupId>
        <artifactId>es-cqrs</artifactId>
        <version>1.0.5-SNAPSHOT</version>
        <scope>import</scope>
        <type>pom</type>
      </dependency>
    </dependencies>
  </dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.github.daggerok.es.api</groupId>
      <artifactId>es-cqrs-api</artifactId>
    </dependency>
  </dependencies>
  <!-- ... -->
</project>
```

_prepare release_

```bash
./mvnw --batch-mode release:clean \
                    release:prepare \
                    release:perform \
                      -DgenerateBackupPoms=false \
                      -DskipTests -Dgroups=!e2e -Darguments="-DskipTests -Dgroups=!e2e"

# if something goes wrong
# ./mvnw release:rollback
```

_update all modules to next SNAPSHOT version manually_

```bash
./mvnw build-helper:parse-version versions:set -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.nextIncrementalVersion}-SNAPSHOT
```

_for lazy people_

```bash
## update current
# bash ./bin/local-deploy.sh ; bash ./bin/create-github-release.sh ; bash ./bin/github-maven-repository.sh

## release new version and update maven release and everything else...
bash ./bin/maven-release-plugin.sh ; bash ./bin/local-deploy.sh ; bash ./bin/create-github-release.sh ; bash ./bin/github-maven-repository.sh
```

links:

- https://github.com/opengeospatial/cite/wiki/How-to-create-Releases-with-Maven

- https://maven.apache.org/plugins/maven-scm-publish-plugin/publish-scm-mojo.html
- https://stackoverflow.com/questions/14013644/hosting-a-maven-repository-on-github

- http://maven.apache.org/maven-release/maven-release-plugin/
