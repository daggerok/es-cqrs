#!/usr/bin/env bash
# ./mvnw release:rollback
./mvnw --batch-mode release:clean \
                    release:prepare \
                    release:perform \
                      -DgenerateBackupPoms=false \
                      -DskipTests -Darguments="-DskipTests"
#./mvnw --batch-mode release:clean \
#                    release:prepare \
#                    release:perform \
#                      -DgenerateBackupPoms=false \
#                      -DskipTests -Dgroups=!e2e -Darguments="-DskipTests -Dgroups=!e2e"
