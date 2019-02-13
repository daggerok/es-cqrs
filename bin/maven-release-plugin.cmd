@echo off
rem call mvnw release:rollback
call mvnw --batch-mode release:clean^
                       release:prepare^
                       release:perform^
                         -DgenerateBackupPoms=false^
                         -DskipTests -Dgroups=!e2e -Darguments="-DskipTests -Dgroups=!e2e"
