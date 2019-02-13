@echo off
rem call mvnw release:rollback
call mvnw --batch-mode release:clean^
                       release:prepare^
                       release:perform^
                         -DgenerateBackupPoms=false^
                         -DskipTests -Darguments="-DskipTests"
