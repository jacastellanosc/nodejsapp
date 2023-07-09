job('Aplicacion Node JS DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
        git('https://github.com/jacastellanosc/nodejsapp.git', 'main') { node ->
            node / gitConfigName('jacastellanosc')
            node / gitConfigEmail('jacastellanosc@gmail.com')
        }
    }
    triggers {
        githubPush()
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell('echo "Paso 1"')
        shell('npm install')
    }
    publishers {
        mailer('jacastellanosc@gmail.com', true, true)
    }
}