job('Aplicacion Node JS Docker DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
        git('https://github.com/jacastellanosc/nodejsapp.git', 'main') { node ->
            node / gitConfigName('jacastellanosc')
            node / gitConfigEmail('jacastellanosc@gmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('clickasoft/nodejsapp')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
    publishers {
        mailer('jacastellanosc@gmail.com', true, true)
    }
}