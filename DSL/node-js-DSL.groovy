job('Aplicacion_Node_JS_DSL') {
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
        shell('npm install')
    }
    publishers {
        mailer('jacastellanosc@gmail.com', true, true)
    }
}