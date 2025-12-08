# Configuration Jenkins pour Kubernetes

## 📋 Étapes de Configuration

### 1️⃣ Ajouter le Credential Kubeconfig dans Jenkins

1. Ouvrez Jenkins dans votre navigateur
2. Allez dans **Manage Jenkins** → **Credentials**
3. Cliquez sur **(global)** domain
4. Cliquez sur **Add Credentials**
5. Configurez comme suit :
   - **Kind** : Secret file
   - **File** : Uploadez votre fichier `~/.kube/config`
   - **ID** : `kubeconfig-credentials` (important : utilisez exactement cet ID)
   - **Description** : Kubernetes config file
6. Cliquez sur **Create**

### 2️⃣ Vérifier kubectl sur Jenkins Agent

Si Jenkins s'exécute localement, `kubectl` devrait déjà être disponible. Sinon, installez-le :

```bash
# Pour macOS
brew install kubectl

# Vérifier l'installation
kubectl version --client
```

### 3️⃣ Vérifier le Namespace Kubernetes

Assurez-vous que le namespace `devops` existe :

```bash
kubectl get namespace devops
```

Si le namespace n'existe pas, créez-le :

```bash
kubectl create namespace devops
```

### 4️⃣ Tester le Pipeline

1. Commitez et pushez vos changements :
   ```bash
   git add Jenkinsfile mysql-deployment.yaml spring-deployment.yaml
   git commit -m "Add Kubernetes deployment to Jenkins pipeline"
   git push
   ```

2. Déclenchez un build dans Jenkins

3. Surveillez les logs du pipeline, particulièrement l'étape "Deploy to Kubernetes"

### 5️⃣ Vérifier le Déploiement

Après un build réussi, vérifiez que les pods sont déployés :

```bash
kubectl get pods -n devops
kubectl get svc -n devops
kubectl logs -f deployment/spring-app -n devops
```

## 🔧 Dépannage

### Erreur : "kubeconfig-credentials not found"
- Vérifiez que vous avez bien créé le credential avec l'ID exact `kubeconfig-credentials`

### Erreur : "kubectl: command not found"
- Installez kubectl sur l'agent Jenkins
- Vérifiez que le PATH inclut `/usr/local/bin`

### Erreur : "namespace devops not found"
- Créez le namespace : `kubectl create namespace devops`

### Pods en CrashLoopBackOff
- Vérifiez les logs : `kubectl logs <pod-name> -n devops`
- Vérifiez que l'image Docker est accessible : `docker pull laamyr/devops_project:latest`
- Vérifiez la connexion MySQL

## 📊 Pipeline Complet

Le pipeline Jenkins exécute maintenant les étapes suivantes :

1. ✅ **Checkout** - Récupération du code source
2. ✅ **Build** - Compilation Maven
3. ✅ **Test** - Exécution des tests
4. ✅ **SonarQube Analysis** - Analyse de qualité du code
5. ✅ **Build Docker Image** - Construction de l'image Docker
6. ✅ **Push to Docker Hub** - Publication sur Docker Hub
7. ✅ **Deploy to Kubernetes** - Déploiement automatique sur Kubernetes

## 🎯 Résultat Attendu

Après chaque build réussi, votre application sera automatiquement déployée sur Kubernetes avec :
- MySQL en ClusterIP (port 3306)
- Spring Boot en NodePort (port 30080)
- Données persistantes via PersistentVolume
- Configuration via ConfigMap et Secret
