def githubName = 'arkeino/jenkins-repo'
def displayName = params['arkeino']

job(displayName) {
    logRotator {
        daysToKeep(30)
    }

    description("Generated by SEED job for the repository: ${githubName}")

    properties {
        githubProjectUrl("https://github.com/${githubName}")
    }

    scm {
        git {
            remote {
                url("https://github.com/${githubName}.git")
            }
            branch('master')
        }
    }

    triggers {
        scm('H/1 * * * *')
    }

    wrappers {
        preBuildCleanup()
    }

    steps {
        shell('make fclean')
        shell('make')
        shell('make tests_run')
        shell('make clean')
    }
}
