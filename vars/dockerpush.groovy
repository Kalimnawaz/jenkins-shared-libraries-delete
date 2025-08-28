def call(String Project, String ImageTag, String dockerhubuser) {
    withCredentials([usernamePassword(credentialsId: 'dockerhubcred', usernameVariable: 'dockerhubuser', passwordVariable: 'dockerhubpass')]) {
        sh """
            echo \$dockerhubpass | docker login -u \$dockerhubuser --password-stdin
            docker image tag notes-app:latest \$dockerhubuser/${Project}:${ImageTag}
            docker push \$dockerhubuser/${Project}:${ImageTag}
        """
    }
}
