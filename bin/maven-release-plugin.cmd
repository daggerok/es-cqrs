@echo off
rem call mvnw release:rollback
call mvnw --batch-mode release:clean^
                       release:prepare^
                       release:perform^
                         -DgenerateBackupPoms=false^
                         -DskipTests -Darguments="-DskipTests"
rem call mvnw --batch-mode release:clean^
rem                        release:prepare^
rem                        release:perform^
rem                          -DgenerateBackupPoms=false^
rem                          -DskipTests -Dgroups=!e2e -Darguments="-DskipTests -Dgroups=!e2e"
