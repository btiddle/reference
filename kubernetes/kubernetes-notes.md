kubernetes-notes.md

# Kubernetes

# Table of Contents
<!-- MarkdownTOC -->

- Fundamental Kubernetes principle
  - Creed
  - Abbreviations
  - Common kubectl cmds
  - List of supported resources
  - Types of Kubernetes services
- Preliminaries
  - Home page
  - Documentation
  - Software versions
  - Kubernetes API versions
- Chapter 1: Introducing Kubernetes
  - Container isolation
  - Components that make up a Kubernetes cluster
    - Control Plane \(master node\)
    - Worker node\(s\)
- Chapter 2: First steps with Docker and Kubernetes
  - Images
  - Docker quick start
  - Kubernetes clusters
  - Running a local single-node Kubernetes cluster with Minikube
  - Minikube command line options
  - VBoxManage not found
  - Minikube uninstall
  - Using a hosted Kubernetes cluster with Google Kubernetes Engine \(GKE\)
  - alias and command-line completion for kubectl
  - Deploying your Node.js app
  - kubectl run command
  - pod
  - containers
  - scheduling
  - Docker settings
  - Example Session: ReplicationController + 3 pods + Service via cmd line \(kubectl expose rc \)
    - Deploying your Node.js app
    - Accessing your web application
    - Services
    - Extra step for Minikube
    - Lables
    - The logical parts of your system
    - Horizontally scaling: ReplicationController
    - Kubernetes dashboard
- Chapter 3: Pods: running containers in Kubernetes
  - 3.1 Introducing pods
  - 3.2 Creating pods from YAML or JSON descriptors
    - Explain
    - Create object with YAML
    - Retrieve logs
    - Port forwarding
  - 3.3 Organizing pods with labels
  - 3.4 Listing subsets of pods through label selectors
  - 3.5 Using labels and selectors to constrain pod scheduling
  - 3.6 Annotating pods
  - 3.7 Using namespaces to group resources
  - 3.8 Stopping and removing pods
- Chapter 4: Replication and other controllers: deploying managed pods
  - 4.1 Keeping pods healthy
  - Example Session: Liveness Probe
    - TODO
  - 4.2 Introducing ReplicationControllers
  - Example Session: Create a ReplicationController using JSON or YAML file
    - TODO
  - 4.3 Using ReplicaSets instead of ReplicationControllers
  - Example Session: Create ReplicaSets \(instead of ReplicationControllers\)
    - TODO
  - 4.4 Running exactly one pod on each node with DaemonSets
  - Example Session: DaemonSet
    - TODO
  - 4.5 Running pods that perform a single completable task
  - Example Session: Jobs
    - TODO
  - 4.6 Scheduling Jobs to run periodically or once in the future
- Chapter 5: Services: enabling clients to discover and talk to pods
  - 5.1 Introducing services
    - Method #1: Create a service via "kubectl expose" or file
    - Method #2: Creating a service through a yaml descriptor
    - Testing service from within the cluster
    - kubectl exec -- curl
    - Session affinity property
    - Exposing multiple ports
    - Using named ports
    - Discovering services through environment variables
    - Example Session: ReplicationController + 3 pods + Service via file \(kubia-svc.yaml\)
    - Discovering services through DNS
    - Example: Hit your service by using the service’s name as the hostname
  - 5.2 Connecting to services living outside the cluster
    - Service endpoints
    - Manually configuring endpoints
    - Creating an alias for an external service
  - 5.3 Exposing services to external clients
    - Using a NodePort service
    - JSONPath to get the IPs of all your nodes
    - Exposing a service through an external load balancer
    - Understanding and preventing unnecessary network hops
  - 5.4 Exposing services externally through an Ingress resource
    - Exposing multiple services through the same Ingress
    - Mapping different services to different hosts
    - Configuring Ingress to handle TLS \(HTTPS\) traffic
    - Signaling when a pod is ready to accept connections
    - Adding a readiness probe to a pod
  - 5.6 Using a headless service for discovering individual pods
    - Discovering pods through DNS
    - Discovering all pods—even those that aren’t ready
  - 5.7 Troubleshooting services
- Chapter 6: Volumes: attaching disk storage to containers
  - 6.1 Introducing volumes
    - Volume types
  - 6.2 Using volumes to share data between containers
    - emptyDir volume
    - gitRepo volume
  - 6.3 Accessing files on the worker node’s filesystem
    - hostPath volume
  - 6.4 Using persistent storage
  - 6.5 Decoupling pods from the underlying storage technology
    - PersistentVolumes and PersistentVolumeClaims resources
    - Creating a persistent volume claim
    - Using a PersistentVolumeClaim in a pod
    - Understanding the benefits of using PersistentVolumes and claims
    - Recycling PersistentVolumes
  - 6.6 Dynamic provisioning of PersistentVolumes
    - Defining the available storage types through StorageClass resources
    - Requesting the storage class in a PersistentVolumeClaim
    - Dynamic provisioning without specifying a storage class
- Chapter 7: ConfigMaps and Secrets: configuring applications
  - 7.1 Configuring containerized application
  - 7.2 Passing command-line arguments to containers
    - Defining the command and arguments in Docker
    - Difference between the shell and exec forms
    - Example: MAKING THE INTERVAL CONFIGURABLE IN YOUR FORTUNE IMAGE
    - Overriding the command and arguments in Kubernetes
  - 7.3 Setting environment variables for a container
    - Specifying environment variables in a container definition
    - Referring to an environment variable inside another one
    - Understanding the drawback of hard coding environment variables
  - 7.4 Decoupling configuration with a ConfigMap
    - Overview of ConfigMap
    - --from-literal=ln=lv...Create at cmd line
    - --from-file=fn.........Create from a file, default key name
    - --from-file=ckn=fn.....Create from a file, custom key name
    - --from-file=dn.........Create from files in a directory
    - .......................Combine different options
    - env.name.valueFrom.....Passing a ConfigMap entry to a container as an environment variable
    - .......................Referencing non-existing ConfigMaps in a pod
    - envFrom................Passing all entries of a ConfigMap as environment variables at once
    - valueFrom..............Passing a ConfigMap entry as a command-line argument
    - Using a configMap volume to expose ConfigMap entries as files
    - Using the configMap's entries in a volume
    - Verify nginx is using the mounted config file
    - Exposing certain configMap entries in the volume
    - Understanding that mounting a directory hides existing files in that directory
    - MOUNTING INDIVIDUAL CONFIGMAP ENTRIES AS FILES WITHOUT HIDING OTHER FILES IN THE DIRECTORY
    - SETTING THE FILE PERMISSIONS FOR FILES IN A CONFIGMAP VOLUME
    - Updating an app’s config without having to restart the app
    - UNDERSTANDING HOW THE FILES ARE UPDATED ATOMICALLY
    - UNDERSTANDING THAT FILES MOUNTED INTO EXISTING DIRECTORIES DON’T GET UPDATED
    - UNDERSTANDING THE CONSEQUENCES OF UPDATING A CONFIGMAP
  - 7.5 Using Secrets to pass sensitive data to containers
    - Introducing the default token Secret
    - Comparing ConfigMaps and Secrets
    - INTRODUCING THE STRINGDATA FIELD
    - READING A SECRET’S ENTRY IN A POD
    - Using the Secret in a pod
    - UNDERSTANDING SECRET VOLUMES ARE STORED IN MEMORY
    - EXPOSING A SECRET’S ENTRIES THROUGH ENVIRONMENT VARIABLES
    - Understanding image pull Secrets
    - USING A PRIVATE IMAGE REPOSITORY ON DOCKER HUB
    - USING THE DOCKER-REGISTRY SECRET IN A POD DEFINITION
- Chapter 8: Accessing pod metadata and other resources from applications
  - 8.1 Passing metadata through the Downward API
    - Kubernetes Downward API
    - Exposing metadata through environment variables
    - Passing metadata through files in a downwardAPI volume
    - UPDATING LABELS AND ANNOTATIONS
    - REFERRING TO CONTAINER-LEVEL METADATA IN THE VOLUME SPECIFICATION
    - UNDERSTANDING WHEN TO USE THE DOWNWARD API
  - 8.2 Talking to the Kubernetes API server
    - Exploring the Kubernetes REST API
    - ACCESSING THE API SERVER THROUGH KUBECTL PROXY
    - RETRIEVING A SPECIFIC JOB INSTANCE BY NAME
    - Talking to the API server from within a pod
      - Create a pod to communicate with the API Server
      - Find the API Server's address
      - Verify the server's identity
      - Authenticating with the API Server
      - Disabling role-based access control \(RBAC\)
      - Getting the namespace the pod is running in
    - Simplifying API server communication with ambassador containers
      - Create pod
      - Talking to the API Server through the ambassador
    - Using client libraries to talk to the API server
    - AN EXAMPLE OF INTERACTING WITH KUBERNETES WITH THE FABRIC8 JAVA CLIENT
    - BUILDING YOUR OWN LIBRARY WITH SWAGGER AND OPENAPI
- Chapter 9: Deployments: updating applications declaratively
  - 9.1 Updating applications running in pods
    - Option #1: Deleting old pods and replacing them with new ones
    - Option #2: Spinning up new pods and then deleting the old ones
      - SWITCHING FROM THE OLD TO THE NEW VERSION AT ONCE
      - PERFORMING A ROLLING UPDATE
  - 9.2 Performing an automatic rolling update with a ReplicationController
    - yaml file
    - Pushing updates to the same image tag
    - Understanding why kubectl rolling-update is now obsolete
    - logging -v 6
  - 9.3 Using Deployments for updating apps declaratively
    - Creating a Deployment
    - UNDERSTANDING HOW DEPLOYMENTS CREATE REPLICASETS, WHICH THEN CREATE THE PODS
    - Updating a Deployment
      - Modifying an existing resource in Kubernetes
      - SLOWING DOWN THE ROLLING UPDATE FOR DEMO PURPOSES
      - TRIGGERING THE ROLLING UPDATE
      - UNDERSTANDING THE AWESOMENESS OF DEPLOYMENTS
      - Rolling back a deployment
      - DISPLAYING A DEPLOYMENT’S ROLLOUT HISTORY
      - ROLLING BACK TO A SPECIFIC DEPLOYMENT REVISION
      - Controlling the rate of the rollout
      - Pausing the rollout process
      - RESUMING THE ROLLOUT
      - USING THE PAUSE FEATURE TO PREVENT ROLLOUTS
      - Blocking rollouts of bad versions
      - DEFINING A READINESS PROBE TO PREVENT OUR V3 VERSION FROM BEING ROLLED OUT FULLY

<!-- /MarkdownTOC -->

# Fundamental Kubernetes principle

## Creed

* Instead of telling Kubernetes exactly what actions it should perform,
  you’re only declaratively changing the desired state of the system
  and letting Kubernetes examine the current actual state and reconcile
  it with the desired state. This is true across all of Kubernetes (pg 49).

## Abbreviations
   ds    daemonsets
   job   jobs
   no    node
   rc    replicationcontroller (deprecated, use replicasets instead)
   rs    replicasets
   po    pods
   svc   services (aka Type=ClusterIP)
   n     namespace

## Common kubectl cmds

    $ kubectl cluster-info
    $ kubectl cluster-info dump

    $ kubectl   [get     ]  [no  ]  [ __resource-name__ ]  [ --namaespace <value> }
                [describe]  [rc  ]  [ -l key=value      ]  [ --show-labels        ]
                [delete  ]  [rs  ]  [ --all-namespaces  ]  [                      ]
                [edit    ]  [po  ]  [                   ]  [                      ]
                [        ]  [svc ]  [                   ]  [                      ]
                [        ]  [no  ]  [                   ]  [                      ]
                [        ]  [ds  ]  [                   ]  [                      ]

                [delete  ]  [rs  ]  [ __resource-name__ ]  [ --cascade=false      ]  // delete rc & keep pods running 

                [delete  ]  [jobs]  [                   ]  [                      ]

                [explain ]  [pods]
                [explain ]  [pod.spec]
                [explain ]  [pod.spec.dnsConfig]

                [expose  ]  [rc  ]  [ __resource-name__  ]  [ - -type=LoadBalancer   ] [ --name kubia-http ]

                Use ReplicaSet instead of ReplicationController (deprecated) because better selector functionally.

                [get     ]  [*   ]  [__resource-name__   ]  [ --show-labels           ]  // Display labels
                [        ]  [    ]  [                    ]  [ -o yaml                 ]  // Display resource as a yaml file
                [        ]  [    ]  [                    ]  [ -o json                 ]  // Display resource as a json file
                [        ]  [    ]  [                    ]  [ -L <key>                ]  // Show KEY column with its VALUES
                [        ]  [    ]  [                    ]  [ -L <key>  --show-labels ]  // Show KEY column with its VALUES AND display labels

                [label   ]  [*   ]  [ __resource-name__  ]  [key=value               ]   // Set a label
                [        ]  [    ]  [                    ]  [key-                    ]   // Delete a label

                [logs    ]  [ __resource-name-of-a-pod__ ]  [ -c __conteiner-name__  ] 

                [scale   ]  [rc  ]  [ __resource-name__  ]  [ --replicas=<count>     ]


                kubectl scale job multi-completion-batch-job --replicas 3

                docker login
                kubectl run kubia --image=benjamintiddlefundingcircle/kubia --port=8080 --generator=run/v1
                kubectl scale rc kubia --replicas=3
                kubectl create -f kubia-svc.yaml
                kubectl delete pods --all
                kubectl get -o wide --show-labels replicationcontroller
                kubectl get -o wide --show-labels pods
                kubectl get -o wide --show-labels services

                kubectl exec <POD-NAME> -- hostname
                kubectl exec <POD-NAME> -- curl -s http://<SERVICE-CLUSTER-IP>
                kubectl exec <POD-NAME> -- env | sort

                kubectl exec -it kubia-8vprs bash
                curl http://kubia.default.svc.cluster.local
                curl http://kubia.default
                curl http://kubia

                kubectl describe svc kubia
                kubectl get endpoints kubia

                kubectl get po --all-namespaces

                lsof -nP +c 15 | grep LISTEN

                kubectl apply -f kubia-ingress-tls.yaml     // Use "apply" to update an existing resource.

                kubectl port-forward fortune 8080:80


## List of supported resources
                                $ kubectl api-resources
                                NAME                              SHORTNAMES   APIGROUP                       NAMESPACED   KIND
                                apiservices                                    apiregistration.k8s.io         false        APIService
                                bindings                                                                      true         Binding
                                certificatesigningrequests        csr          certificates.k8s.io            false        CertificateSigningRequest
                                clusterrolebindings                            rbac.authorization.k8s.io      false        ClusterRoleBinding
                                clusterroles                                   rbac.authorization.k8s.io      false        ClusterRole
                                componentstatuses                 cs                                          false        ComponentStatus
                                configmaps                        cm                                          true         ConfigMap
                                controllerrevisions                            apps                           true         ControllerRevision
                                cronjobs                          cj           batch                          true         CronJob
                                csidrivers                                     storage.k8s.io                 false        CSIDriver
                                csinodes                                       storage.k8s.io                 false        CSINode
                                customresourcedefinitions         crd,crds     apiextensions.k8s.io           false        CustomResourceDefinition
                                daemonsets                        ds           apps                           true         DaemonSet
                                deployments                       deploy       apps                           true         Deployment
                                endpoints                         ep                                          true         Endpoints
                                events                            ev                                          true         Event
                                events                            ev           events.k8s.io                  true         Event
                                horizontalpodautoscalers          hpa          autoscaling                    true         HorizontalPodAutoscaler
                                ingresses                         ing          extensions                     true         Ingress
                                ingresses                         ing          networking.k8s.io              true         Ingress
                                jobs                                           batch                          true         Job
                                leases                                         coordination.k8s.io            true         Lease
                                limitranges                       limits                                      true         LimitRange
                                localsubjectaccessreviews                      authorization.k8s.io           true         LocalSubjectAccessReview
                                mutatingwebhookconfigurations                  admissionregistration.k8s.io   false        MutatingWebhookConfiguration
                                namespaces                        ns                                          false        Namespace
                                networkpolicies                   netpol       networking.k8s.io              true         NetworkPolicy
                                nodes                             no                                          false        Node
                                persistentvolumeclaims            pvc                                         true         PersistentVolumeClaim
                                persistentvolumes                 pv                                          false        PersistentVolume
                                poddisruptionbudgets              pdb          policy                         true         PodDisruptionBudget
                                pods                              po                                          true         Pod
                                podsecuritypolicies               psp          policy                         false        PodSecurityPolicy
                                podtemplates                                                                  true         PodTemplate
                                priorityclasses                   pc           scheduling.k8s.io              false        PriorityClass
                                replicasets                       rs           apps                           true         ReplicaSet
                                replicationcontrollers            rc                                          true         ReplicationController
                                resourcequotas                    quota                                       true         ResourceQuota
                                rolebindings                                   rbac.authorization.k8s.io      true         RoleBinding
                                roles                                          rbac.authorization.k8s.io      true         Role
                                runtimeclasses                                 node.k8s.io                    false        RuntimeClass
                                secrets                                                                       true         Secret
                                selfsubjectaccessreviews                       authorization.k8s.io           false        SelfSubjectAccessReview
                                selfsubjectrulesreviews                        authorization.k8s.io           false        SelfSubjectRulesReview
                                serviceaccounts                   sa                                          true         ServiceAccount
                                services                          svc                                         true         Service
                                statefulsets                      sts          apps                           true         StatefulSet
                                storageclasses                    sc           storage.k8s.io                 false        StorageClass
                                subjectaccessreviews                           authorization.k8s.io           false        SubjectAccessReview
                                tokenreviews                                   authentication.k8s.io          false        TokenReview
                                validatingwebhookconfigurations                admissionregistration.k8s.io   false        ValidatingWebhookConfiguration
                                volumeattachments                              storage.k8s.io                 false        VolumeAttachment

## Types of Kubernetes services

* There are four types of Kubernetes services:

1. ClusterIP

This default type exposes the service on a cluster-internal IP. You can reach
the service only from within the cluster.

2. NodePort

This type of service exposes the service on each node’s IP at a static port. A
ClusterIP service is created automatically, and the NodePort service will route
to it. From outside the cluster, you can contact the NodePort service by 
using “<NodeIP>:<NodePort>”.

3. LoadBalancer

This service type exposes the service externally using the load balancer of your
cloud provider. The external load balancer routes to your NodePort and ClusterIP
services, which are created automatically.

4. ExternalName

This type maps the service to the contents of the externalName field
(e.g., foo.bar.example.com). It does this by returning a value for the CNAME
record.

# Preliminaries

## Home page
  https://kubernetes.io/

## Documentation
  https://kubernetes.io/docs/home/

## Software versions 

    $ docker --version
    Docker version 19.03.4, build 9013bf5

    $ minikube version
    minikube version: v1.5.2
    commit: 792dbf92a1de583fcee76f8791cff12e0c9440ad

    # Kubernetes
    $ kubectl version  --short=true
    Client Version: v1.16.3
    Server Version: v1.16.2

## Kubernetes API versions

* Kubenetes Deprecated APIs

  * Kubernetes version 1.16 has removed several deprecated APIs
    * https://www.ibm.com/cloud/blog/announcements/kubernetes-version-1-16-removes-deprecated-apis
    * apps/v1beta1 - completely removed
    * apps/v1beta2 - completely removed
    * extensions/v1beta1 - removed for select resources
    * Removal of these APIs impacts the following Kubernetes resources: NetworkPolicy, PodSecurityPolicy, DaemonSet, Deployment, StatefulSet, and ReplicaSet. 
    * Overview of the replacement APIs
      * Use the networking.k8s.io/v1 API for NetworkPolicy resources.
      * Use the policy/v1beta1 API for PodSecurityPolicy resources.
      * Use the apps/v1 API for DaemonSet, Deployment, StatefulSet, and ReplicaSet resources.

  * Deprecated APIs Removed In 1.16: Here’s What You Need To Know
    * https://kubernetes.io/blog/2019/07/18/api-deprecations-in-1-16/

  * Which Kubernetes apiVersion Should I Use?
    * https://matthewpalmer.net/kubernetes-app-developer/articles/kubernetes-apiversion-definition-guide.html

  * apiVersion and beta versions
    * https://stackoverflow.com/questions/38547229/apiversion-and-beta-versions

# Chapter 1: Introducing Kubernetes

## Container isolation

* Two mechanisms makes it possible

  * Linux Namespaces makes sure each process sees its own personal view of
    the system (files, processes, network interfaces, hostname, and so on).

  * Linux Control Groups (cgroups), which limit the amount of resources the process
    can consume (CPU, memory, network bandwidth, and so on).

* A process doesn’t belong to one namespace, but to one namespace of each kind.

  * Mount (mnt)
  * Process ID (pid)
  * Network (net) (determines which network interfaces the application sees)
  * Inter-process communication (ipc)
  * UTS (determines what hostname and domain name are seen)
  * User ID (user)

## Components that make up a Kubernetes cluster

  * Kubernetes cluster is composed of many nodes, which can be split
    into two types:

    * master node
      * Hosts the Kubernetes Control Plane

    * worker node(s)
      * Run the actual applications you deploy

### Control Plane (master node)
  * API server
  * Scheduler
  * Controller Manager
  * etcd

  * Control Plane
    * Hold and control the state of the cluster

  * Kubernetes API Server
    * Used by user and Control Plane components to communicate 

  * Scheduler
    * Schedules your apps; assigns a worker node to each deployable
      component of your application

  * Controller Manager
    * Performs cluster-level functions, such as replicating components,
      keeping track of worker nodes, handling node failures, and so on

  * etcd
    * A reliable distributed data store that persistently stores the
      cluster configuration.

### Worker node(s)
  * Kubelet
  * Container Runtime
  * kube-proxy

  * Worker nodes
    * Are the machines that run your containerized applications.

  * Kubelet
    * Talks to the API server and manages containers on its node

  * Container Runtime
    * Docker, rkt, or another container runtime that runs your containers

  * Kubernetes Service Proxy (kube-proxy)
    * Load-balances network traffic between application components

# Chapter 2: First steps with Docker and Kubernetes

## Images

* Docker Hub
  https://hub.docker.com/

* busybox - Simple echo "Hello world" command.
  docker run busybox echo "Hello world"
  docker run -it --rm busybox

* Fedora
  docker run fedora echo "Hello world"

* Ubuntu
  docker run ubuntu echo "Hello world"

## Docker quick start

Description                   Syntax                                   Example
                                                                       
my docker id                  benjamintiddlefundingcircle
                              
run latest image              docker run <image>                       docker run busybox echo "Hello world"
                              
run specific tag              docker run <image>:<tag>                 docker run busybox:1.29.2 echo "Hello world"
                              
build a docker image          docker build -t <app-name> <dir-loc>     docker build -t kubia .
                              
list locally stored images    docker images
                              REPOSITORY                           TAG                                   IMAGE ID            CREATED             SIZE
                              kubia                                latest                                84931fa34614        6 seconds ago       660MB
                              ...

list 1st ten images           docker images | head
                              REPOSITORY                           TAG                                   IMAGE ID            CREATED             SIZE
                              kubia                                latest                                1f625906adb6        5 minutes ago       660MB
                              k8s.gcr.io/kube-proxy                v1.14.7                               230ef35b6bb8        6 weeks ago         82.1MB
                              k8s.gcr.io/kube-apiserver            v1.14.7                               364c383af37c        6 weeks ago         209MB
                              k8s.gcr.io/kube-controller-manager   v1.14.7                               02d90e944162        6 weeks ago         158MB
                              k8s.gcr.io/kube-scheduler            v1.14.7                               72c01550199f        6 weeks ago         81.6MB
                              quay.io/fundingcircle/end-to-end     FUG-114-finops-admin-mock-auth_1001   d459825d0675        6 weeks ago         939MB
                              test-end-to-end                      latest                                ef0fa4bf9e5c        6 weeks ago         564MB
                              quay.io/fundingcircle/end-to-end     FUG-114-finops-admin-mock-auth_998    5fe59b012543        6 weeks ago         939MB
                              quay.io/fundingcircle/end-to-end     FUG-114-finops-admin-mock-auth_997    8011059d055b        7 weeks ago         939MB

run container kubia           docker run --name kubia-container -p 8080:8080 -d kubia
                              This tells Docker to run a new container called kubia-container from the kubia
                              image. The container will be detached from the console (-d flag), which means it will
                              run in the background. Port 8080 on the local machine will be mapped to port 8080
                              inside the container (-p 8080:8080 option), so you can access the app through
                              http://localhost:8080
                              
                              http://localhost:8080
                              You've hit b4c4791228c5
                              
                              curl localhost:8080
                              You've hit b4c4791228c5
                              
list all running containers   docker ps
                              CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS              PORTS                    NAMES
                              b4c4791228c5        kubia               "node app.js"       5 minutes ago       Up 5 minutes        0.0.0.0:8080->8080/tcp   kubia-container
                              
list container information    docker inspect kubia-container
                              Returns a JSON object
                              
running a shell in container  $ docker exec -it kubia-container bash
                              -i, keep STDIN open (type commands)
                              -t, allocates a pseudo terminal (display command prompt)

list process                  $ ps aux
                              USER       PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
                              root         1  0.0  1.2 813600 25968 ?        Ssl  21:02   0:00 node app.js
                              root        11  0.0  0.1  20244  3248 pts/0    Ss   21:20   0:00 bash
                              root        20  0.0  0.1  17500  2108 pts/0    R+   21:35   0:00 ps aux
                              
exit container                exit
                              
stop app/container            docker stop <name>                        $ docker stop kubia-container
                                                                        $ kubia-container

list existing containers      docker ps -a
                              CONTAINER ID        IMAGE             COMMAND                  CREATED             STATUS                         PORTS               NAMES
                              b4c4791228c5        kubia             "node app.js"            48 minutes ago      Exited (137) 4 minutes ago                         kubia-container
                              fe441e610ff3        busybox:1.29.2    "echo 'Hello world'"     About an hour ago   Exited (0) About an hour ago                       bold_keller
                              ...
                              -a, prints out all the containers, those running and those that have been stopped.

remove container              docker rm <name>-container                $ docker rm kubia-container

tag image under an            docker tag <c-name> <id>/<c-name>         $ docker tag kubia benjamintiddlefundingcircle/kubia
  additional tag name 

list locally stored images    $ docker images
                              REPOSITORY                           TAG                                   IMAGE ID            CREATED              SIZE
                              benjamintiddlefundingcircle/kubia    latest                                84931fa34614        About a minute ago   660MB
                              kubia                                latest                                84931fa34614        About a minute ago   660MB

docker login                  docker login

push image to docker hub      $ docker push benjamintiddlefundingcircle/kubia

run image on any machine      docker run -p 8080:8080 -d <id>/<c-name>   $ docker run -p 8080:8080 -d benjamintiddlefundingcircle/kubia
                              http://localhost:8080
                              curl localhost:8080

list running container        $ docker ps
                              CONTAINER ID        IMAGE                               COMMAND             CREATED             STATUS              PORTS                    NAMES
                              6247a05c8ae7        benjamintiddlefundingcirc

logs of running container     $ docker logs <container-id>               $ docker logs 6247a05c8ae7
                                                                         Kubia server starting...

## Kubernetes clusters

* Minikube single-node Kubernetes cluster on your local machine (Chapter 2)
  * Has only one node that acts both as a master and a worker node
* Hosted cluster running on Google Kubernetes Engine (GKE) previously known as Google Container Engine) (Chapter 2) 
  * A three-node Kubernetes cluster
* Installing a cluster with the kubeadm tool (Appendix B)
* Install Kubernetes on Amazon’s AWS (Amazon Web Services) using tools kops and kubeadm (http://github.com/kubernetes/kops.)

## Running a local single-node Kubernetes cluster with Minikube

* Repository
  https://github.com/kubernetes/minikube

* Install
  $ brew cask install minikube
  or
  brew install minikube
  https://github.com/kubernetes/website/issues/17290


* Starting a kubernetes cluster with minikub
  $ minikube start

  * Error: VBoxManage not found
    https://www.code2bits.com/how-to-install-virtualbox-on-macos-using-homebrew/
    $ brew cask install virtualbox

  * https://developer.apple.com/library/archive/technotes/tn2459/_index.html
    System Preferences > Security & Privacy and button "Allow"

  * Reboot mac

  * Repeat 
    $ minikube start

* Installing the kubernetes client (kubectl)
  https://kubernetes.io/docs/tasks/tools/install-kubectl/#install-with-homebrew-on-macos
  $ brew install kubectl 

* Display cluster information     $ kubectl cluster-info
                                  Kubernetes master is running at https://192.168.99.100:8443
                                  KubeDNS is running at https://192.168.99.100:8443/api/v1/namespaces/kube-system/services/kube-dns:dns/proxy

* To debug and diagnose cluster   $ kubectl cluster-info dump

* List namespaces in cluster      $ kubectl get namespaces
                                  NAME                   STATUS   AGE
                                  default                Active   77m
                                  kube-node-lease        Active   77m
                                  kube-public            Active   77m
                                  kube-system            Active   77m
                                  kubernetes-dashboard   Active   54m

* List cluster nodes              $ kubectl get nodes
                                  NAME       STATUS   ROLES    AGE   VERSION
                                  minikube   Ready    master   86m   v1.16.0

* Detailed info about an object   $ kubectl describe node minikube
                                  A long list if information

* Detailed info about all objects $ kubectl describe node
                                  An even longer list if more then one object (i.e. node in this case)

* Install Web UI (Dashboard)
  https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/
  $ kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-beta4/aio/deploy/recommended.yaml

* Create user
  https://github.com/kubernetes/dashboard/blob/master/docs/user/access-control/creating-sample-user.md
  Create dashboard-adminuser.yaml
  $ kubectl apply -f dashboard-adminuser.yaml
  clusterrolebinding.rbac.authorization.k8s.io/admin-user created

* Generate Bearer Token
  $ kubectl -n kubernetes-dashboard describe secret $(kubectl -n kubernetes-dashboard get secret | grep admin-user | awk '{print $1}')
  Save output to file bearer-token.txt

* Accessing the Dashboard UI
  $ kubectl proxy
  Browser: http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/
  Enter token

* TODO: Got UI to display, but could not figure out how to load application into cluster.

## Minikube command line options

$ minikube

Minikube is a CLI tool that provisions and manages single-node Kubernetes clusters optimized for development workflows.

Basic Commands:
  start          Starts a local kubernetes cluster
  status         Gets the status of a local kubernetes cluster
  stop           Stops a running local kubernetes cluster
  delete         Deletes a local kubernetes cluster
  dashboard      Access the kubernetes dashboard running within the minikube cluster

Images Commands:
  docker-env     Sets up docker env variables; similar to '$(docker-machine env)'
  cache          Add or delete an image from the local cache.

Configuration and Management Commands:
  addons         Modify minikube's kubernetes addons
  config         Modify minikube config
  profile        Profile gets or sets the current minikube profile
  update-context Verify the IP address of the running cluster in kubeconfig.

Networking and Connectivity Commands:
  service        Gets the kubernetes URL(s) for the specified service in your local cluster
  tunnel         tunnel makes services of type LoadBalancer accessible on localhost

Advanced Commands:
  mount          Mounts the specified directory into minikube
  ssh            Log into or run a command on a machine with SSH; similar to 'docker-machine ssh'
  kubectl        Run kubectl

Troubleshooting Commands:
  ssh-key        Retrieve the ssh identity key path of the specified cluster
  ip             Retrieves the IP address of the running cluster
  logs           Gets the logs of the running instance, used for debugging minikube, not user code.
  update-check   Print current and latest version number
  version        Print the version of minikube

Other Commands:
  completion     Outputs minikube shell completion for the given shell (bash or zsh)

* kubernetes minikube EXTERNAL-IP pending
  LoadBalancer Service has pending IP address #4113
  https://github.com/kubernetes/minikube/issues/4113

* minikube addons list
    - addon-manager: enabled
    - dashboard: disabled
    - default-storageclass: enabled
    - efk: disabled
    - freshpod: disabled
    - gvisor: disabled
    - helm-tiller: disabled
    - ingress: disabled
    - ingress-dns: disabled
    - logviewer: disabled
    - metrics-server: disabled
    - nvidia-driver-installer: disabled
    - nvidia-gpu-device-plugin: disabled
    - registry: disabled
    - registry-creds: disabled
    - storage-provisioner: enabled
    - storage-provisioner-gluster: disabled

## VBoxManage not found

https://www.code2bits.com/how-to-install-virtualbox-on-macos-using-homebrew/
$ brew cask install virtualbox

==> Caveats
To install and/or use virtualbox you may need to enable its kernel extension in:
  System Preferences → Security & Privacy → General
For more information refer to vendor documentation or this Apple Technical Note:
  https://developer.apple.com/library/content/technotes/tn2459/_index.html

https://stackoverflow.com/questions/52277019/how-to-fix-vm-issue-with-minikube-start

## Minikube uninstall

* How to uninstall [minikube]? #1043
  https://github.com/kubernetes/minikube/issues/1043

## Using a hosted Kubernetes cluster with Google Kubernetes Engine (GKE)

* TODO: Read along, but did not attempt to do.

## alias and command-line completion for kubectl

* Alias
  alias k=kubectl

* To enable tab completion in bash
  Install package bashcompletion
  $ source <(kubectl completion bash)
  Also, add to \~/.bash_profile (or equivalent)


## Deploying your Node.js app

* Ways to deploy app
  * kubectl run command
  * JSON file
  * YAML file

## kubectl run command

## pod
   * The basic building block in Kubernetes is the pod
   * A pod is a group of one or more tightly related containers that 
     will always run together on the same worker node and in the same
     Linux namespace(s).
   * Each pod has a separate logical machine with its own IP, hostname, 
     processes, and so on.
   * All the containers in a pod will appear to be running on the same
     logical machine.
   * worker node = 1 or more pods 
   * pods = 1 or more containers
   * pods are ephemeral, may disappear at any time
     * new pod gets a different IP address from the pod it’s replacing
     * services solve the problem of ever-changing pod IP addresses
       and exposing multiple pods at a single constant IP and port pair.

## containers
   * can’t list individual containers, since they’re not standalone 
     Kubernetes objects

## scheduling
   * Means assigning the pod to a node
   * The pod is run immediately, not at a time in the future

## Docker settings

* After Reset (or new install):
  * Advanced >
    * Memory = 6.0 GB

## Example Session: ReplicationController + 3 pods + Service via cmd line (kubectl expose rc )

### Deploying your Node.js app
   * Using "kubectl run" 
   * Get app from repository and automatically creates replicationcontroller (using --generator)

* Docker login                   $ docker login
                                 Authenticating with existing credentials...
                                 Login Succeeded

* list rc, svc & pod             $ kubectl get replicationcontroller
                                 No resources found in default namespace.
                                
                                 $ kubectl get services
                                 NAME         TYPE        CLUSTER-IP   EXTERNAL-IP   PORT(S)   AGE
                                 kubernetes   ClusterIP   10.96.0.1    <none>        443/TCP   21h
                                
                                 $ kubectl get pods
                                 No resources found in default namespace.

* create rc for kubia            $ kubectl run kubia --image=benjamintiddlefundingcircle/kubia --port=8080 --generator=run/v1
                                 replicationcontroller/kubia created

                                 --generator, using it here so Kubernetes creates a ReplicationController instead of a Deployment

* list rc, svc & pod             $ kubectl get services
                                 NAME         TYPE        CLUSTER-IP   EXTERNAL-IP   PORT(S)   AGE
                                 kubernetes   ClusterIP   10.96.0.1    <none>        443/TCP   21h
                                 
                                 $ kubectl get replicationcontroller
                                 NAME    DESIRED   CURRENT   READY   AGE
                                 kubia   1         1         1       18s
                                 
                                 $ kubectl get pods
                                 NAME          READY   STATUS    RESTARTS   AGE
                                 kubia-2nxtm   1/1     Running   0          18s

* describe pod                   $ kubectl describe pod
                                 Name:           kubia-2nxtm
                                 Namespace:      default
                                 Priority:       0
                                 Node:           docker-desktop/192.168.65.3
                                 Start Time:     Sat, 02 Nov 2019 08:16:00 -0700
                                 Labels:         run=kubia
                                 Annotations:    <none>
                                 Status:         Running
                                 ...

### Accessing your web application
   * Each pod gets its own IP address, but this address is internal to
     the cluster and isn’t accessible from outside of it.
   * Make pod accessible by exposing it through a Service object.
   * To create the service, you’ll tell Kubernetes to expose the 
     ReplicationController you created earlier.

### Services
   * Are objects just like Pods and Nodes

* expose ip address              $ kubectl expose rc kubia --type=LoadBalancer --name kubia-http
                                 service/kubia-http exposed

* list rc, svc & pod             $  kubectl get replicationcontroller
  See service EXTERNAL-IP set    NAME    DESIRED   CURRENT   READY   AGE
  to an address                  kubia   1         1         1       5m54s
                                 
                                 $ kubectl get services
                                 NAME         TYPE           CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
                                 kubernetes   ClusterIP      10.96.0.1       <none>        443/TCP          21h
                                 kubia-http   LoadBalancer   10.104.42.234   localhost     8080:31660/TCP   23s
                                 
                                 $ kubectl get pods
                                 NAME          READY   STATUS    RESTARTS   AGE
                                 kubia-2nxtm   1/1     Running   0          5m54s

* describe service               $ kubectl describe svc kubia-http
  See Selector value             Name:                     kubia-http
                                 Namespace:                default
                                 Labels:                   run=kubia
                                 Annotations:              <none>
                                 Selector:                 run=kubia
                                 Type:                     LoadBalancer
                                 IP:                       10.104.42.234
                                 LoadBalancer Ingress:     localhost
                                 Port:                     <unset>  8080/TCP
                                 TargetPort:               8080/TCP
                                 NodePort:                 <unset>  31660/TCP
                                 Endpoints:                10.1.0.44:8080
                                 Session Affinity:         None
                                 External Traffic Policy:  Cluster
                                 Events:                   <none>

### Extra step for Minikube
  * When using minikube, must use tunnel to change "EXTERNAL-IP=<pending>" to an actual address

* For Minikube only              $ minikube tunnel
                                 Prints status of minikube tunnel status continuously in terminal window

* Confirm connection             Check EXTERNAL-IP of kubectl get services
                                 http://localhost:8080/  or http://10.96.171.217:8080/
                                 You've hit kubia-2nxtm

                                 $ curl localhost:8080  or $ curl 10.96.171.217:8080
                                 You've hit kubia-2nxtm

### Lables
    * ReplicationController   Rudimentary label functionality
    * ReplicaSet              Advanced label functionality

### The logical parts of your system

Note: EXTERNAL-IP displays using docker-desktop. 
      EXTERNAL-IP DOES NOT display using minikube.

1. Create a Replication Controller that creates a Pod containing the deployed Container
   $ kubectl run kubia --image=benjamintiddlefundingcircle/kubia --port=8080 --generator=run/v1
   replicationcontroller/kubia created

2. Create additional Replication Controllers to create more Pods 
   $ kubectl scale rc kubia --replicas=3
   replicationcontroller/kubia scaled

3. Create a Service that configures internal/external IP address for the Pods

   Using "kubectl expose rc <RC-NAME>"
   $ kubectl expose rc kubia --type=LoadBalancer --name kubia-http
   service/kubia-http exposed
   (both internal and external IP address created)

   Or using YAML file
   $ kubectl create -f kubia-svc.yaml
   service/kubia created
   (only internal IP address created)

4. Will need to restart pods (to pick up setup of external IP address via Service)
   (Alternatively, could have created Service before creating Pods).
   $ kubectl delete pods --all

   http://localhost:8080/
   You've hit kubia-bc9gv

   curl localhost:8080
   You've hit kubia-snsh7


### Horizontally scaling: ReplicationController
   * Makes sure there’s always exactly one instance of your pod running.
   * To replicate pods, multiple ReplicationControllers are used

* scale up number of rc's        $ kubectl scale rc kubia --replicas=3
                                 replicationcontroller/kubia scaled

* list rc, svc & pod             $ kubectl get replicationcontroller
  See rc count increase          NAME    DESIRED   CURRENT   READY   AGE
  See pod count increase         kubia   3         3         3       21m
                                 
                                 $ kubectl get services
                                 NAME         TYPE           CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
                                 kubernetes   ClusterIP      10.96.0.1       <none>        443/TCP          22h
                                 kubia-http   LoadBalancer   10.104.42.234   localhost     8080:31660/TCP   16m
                                 
                                 $ kubectl get pods
                                 NAME          READY   STATUS    RESTARTS   AGE
                                 kubia-2nxtm   1/1     Running   0          21m
                                 kubia-6hrdd   1/1     Running   0          49s
                                 kubia-rjf2w   1/1     Running   0          49s

* list pods -o wide              $ kubectl get pods -o wide
  See pods IP internal           NAME          READY   STATUS    RESTARTS   AGE     IP          NODE             NOMINATED NODE   READINESS GATES
  address values                 kubia-2nxtm   1/1     Running   0          23m     10.1.0.44   docker-desktop   <none>           <none>
                                 kubia-6hrdd   1/1     Running   0          2m37s   10.1.0.46   docker-desktop   <none>           <none>
                                 kubia-rjf2w   1/1     Running   0          2m37s   10.1.0.45   docker-desktop   <none>           <none>

* describe a pod                 $ kubectl describe pod kubia-2nxtm
  See Labels value               Name:           kubia-2nxtm
                                 Namespace:      default
                                 Priority:       0
                                 Node:           docker-desktop/192.168.65.3
                                 Start Time:     Sat, 02 Nov 2019 08:16:00 -0700
                                 Labels:         run=kubia
                                 Annotations:    <none>
                                 Status:         Running
                                 IP:             10.1.0.44
                                 IPs:            <none>

* See the diff pods getting      $ curl localhost:8080
  hit with same IP address!      You've hit kubia-2nxtm

                                 $ curl localhost:8080
                                 You've hit kubia-6hrdd

                                 $ curl localhost:8080
                                 You've hit kubia-rjf2w

* exec curl cmd on each          $ kubectl exec kubia-2nxtm -- curl -s http://localhost:8080
  pod using same EXTERNAL-IP     You've hit kubia-2nxtm
  address
                                 $ kubectl exec kubia-6hrdd -- curl -s http://localhost:8080
                                 You've hit kubia-6hrdd

                                 $ kubectl exec kubia-rjf2w -- curl -s http://localhost:8080
                                 You've hit kubia-rjf2w

### Kubernetes dashboard

* See page 52.

# Chapter 3: Pods: running containers in Kubernetes

## 3.1 Introducing pods

   * Pods are the central, most important, concept in Kubernetes
   * Everything else either manages, exposes, or is used by pods.

* MULTIPLE CONTAINERS ARE BETTER THAN ONE CONTAINER RUNNING MULTIPLE PROCESSES
  * Containers are designed to run only a single process per container
  * If multiple unrelated processes in a single container:
    * your responsibility to keep all those processes running
    * manage their logs (when printing to the same standard output)
    * automatically restarting individual processes if they crash

* A pod of containers allows you to run closely related processes together and provide
  them with (almost) the same environment as if they were all running in a single
  container, while keeping them somewhat isolated.

* Kubernetes uses Docker to have all containers of a pod share the same set of
  Linux namespaces instead of each container having its own set.

* All containers of a pod run under the same Network and UTS (Linux) namespaces,
  thus share the same hostname and network interfaces.

* Containers of a pod run under the same IPC namespace and can communicate through IPC.

* By default, the filesystem of each container is fully isolated from other containers.

* Containers share the same IP and port space

* All pods in a Kubernetes cluster reside in a single flat, shared, network-address space

* Communication between pods is always simple

* Running both the frontend server and the database in a single pod (with one or 
  two containers), isn’t the most appropriate way to do it.
  * Bad infrastructure utilization
  * Unable to scale individually

* Use multiple containers in a pod only when they are tightly coupled
  * A container shouldn’t run multiple processes. 
  * A pod shouldn’t contain multiple containers if they don’t need to run on the same machine.

* Single-container pods are the BEST!

## 3.2 Creating pods from YAML or JSON descriptors

* Resources created by posting JSON or YAML to Kubernetes REST API endpoint

* Resources created using "kubectl run", but less functional.

* Kubernetes API reference documentation at http://kubernetes.io/docs/reference/

* list YMAL of a pod          $ kubectl get po kubia-6ghlr -o yaml
                              <YAML output>

* Typical structure of a Kubernetes API object
  * Kubernetes API version
  * Type of resource
  * Metadata
  * Spec, description of the pod’s contents
  * Status

* A basic pod manifest: kubia-manual.yaml

apiVersion: v1
kind: Pod
metadata:
  name: kubia-manual
spec:
  containers:
  - image: benjamintiddlefundingcircle/kubia
      name: kubia
      ports:
      - containerPort: 8080
        protocol: TCP

### Explain

* explain feature             $ kubectl explain pods
                              <explanatinon displayed>

* explain more                $ kubectl explain pod.spec

### Create object with YAML

* create resource from YAML   $ kubectl create -f kubia-manual.yaml
                              pod/kubia-manual created

### Retrieve logs

* retrieve logs               $ kubectl logs kubia-manual

* when multiple containers    $ kubectl logs kubia-manual -c <c-name>

* Can only retrieve container logs of pods that are still in existence.


### Port forwarding

* configure port forwarding   $ kubectl port-forward kubia-manual 8888:8080
  to the pod.                 $ curl localhost:8888

## 3.3 Organizing pods with labels

* labels
  * Organizing pods and all other Kubernetes objects is done through labels.
  * A label is an arbitrary key-value pair you attach to a resource
  * Select resources using label selectors
  * A resource can have more than one label, as long as the keys of those
    labels are unique within that resource.
  * multiple labels
    * By adding these two labels, you’ve essentially organized your pods
      into two dimensions (horizontally by app and vertically by release),
   * Can specify label in YAML 

* show labels                 $ kubectl get po --show-labels
                              NAME             READY   STATUS             RESTARTS   AGE   LABELS
                              kubia-67tkh      0/1     ImagePullBackOff   0          41m   run=kubia
                              kubia-6mnfq      0/1     ImagePullBackOff   0          41m   run=kubia
                              kubia-flc75      0/1     ImagePullBackOff   0          41m   run=kubia
                              kubia-jqm88      0/1     ImagePullBackOff   0          41m   run=kubia
                              kubia-manual     0/1     ImagePullBackOff   0          70m   <none>
                              kubia-manual-b   0/1     ImagePullBackOff   0          55m   <none>

* show certain labels         $ kubectl get po -L run=kubia

* change labels               $ kubectl label po kubia-manual creation_method=manual

* overwrite label             $ kubectl label po kubia-manual-v2 env=debug --overwrite

## 3.4 Listing subsets of pods through label selectors

* Label selectors 
  * Allow you to select a subset of pods tagged with certain labels
    and perform an operation on those pods.

* has label                   $ kubectl get po -l creation_method=manual

* has label                   $ kubectl get po -l env

* does not have label         $ kubectl get po --show-labels -l '!env'
                              Make sure to use single quotes around !env, 
                              so the bash shell doesn’t evaluate the
                              exclamation mark.

* not equal                   $ kubectl get po -l creation_method!=manual

* in set                      $ kubectl get po -l env in (prod,devel)

* not in set                  $ kubectl get po -l env notin (prod,devel)

* multiple criteria           $ kubectl get po -l app=pc,rel=beta

## 3.5 Using labels and selectors to constrain pod scheduling

* You can describe the node requirements and then let Kubernetes select a
  node that matches those requirements. This can be done through node labels and
  node label selectors.

* Labels can be attached to any Kubernetes object, including nodes.

* label a node                $ kubectl label node gke-kubia-85f6-node-0rrx gpu=true

* list only nodes that 
  include the label gpu=true  $ kubectl get nodes -l gpu=true

* label selector to schedule a pod (i.e. gpu: "true")

  apiVersion: v1
  kind: Pod
   metadata:
     name: kubia-gpu
  spec:
    nodeSelector:
      gpu: "true"
    containers:
    - image: luksa/kubia
      name: kubia

## 3.6 Annotating pods

* Objects can also contain annotations

* Annotations are also key-value pairs, so in essence, they’re
  similar to labels, but they aren’t meant to hold identifying
  information.
* can hold much larger pieces of information (up to 256 KB in total)
* primarily meant to be used by tools.
* Some added by Kubernetes,
* Some added by user
* Also commonly used when introducing new features
* Great use of annotations is adding descriptions for each pod or other API object

* view annotations vis xml    $ kubectl get po kubia-zxzij -o yaml

* add annotation              $ kubectl annotate pod kubia-manual mycompany.com/someannotation="foo bar"
                              Good idea to use this format for annotation keys to prevent key collisions. 
                              When different tools or libraries add annotations to objects, they may
                              accidentally override each other’s annotations if they don’t use unique
                              prefixes like you did here.

* view annotation             $ kubectl describe pod kubia-manual

## 3.7 Using namespaces to group resources

* Kubernetes also groups objects into namespaces. These aren’t the Linux
namespaces we talked about in chapter 2, which are used to isolate processes from
each other.

* Can split resources into multiple namespaces,

* Which also allows you to use the same resource names multiple times (across
different namespaces).

* Resource names only need to be unique within a namespace.

* NOTE: Node resource (and a few others) are not namedspaced.

* namespaces are also used for allowing only certain users access to
  particular resources and even for limiting the amount of computational
  resources available to individual users.

* namespaces can be scoped in a single contexts or across multiple contexts.

* list all namespaces         $ kubectl get ns
                              NAME                   STATUS   AGE
                              default                Active   20h
                              kube-node-lease        Active   20h
                              kube-public            Active   20h
                              kube-system            Active   20h
                              kubernetes-dashboard   Active   19h
                              By default, the "default" namespace is used when not specified.

* pods in kube-system         $ kubectl get po --namespace kube-system
  namespace                   NAME                               READY   STATUS    RESTARTS   AGE
                              coredns-5644d7b6d9-vh7vj           1/1     Running   1          20h
                              coredns-5644d7b6d9-x4zmd           1/1     Running   1          20h
                              etcd-minikube                      1/1     Running   1          20h
                              kube-addon-manager-minikube        1/1     Running   1          20h
                              kube-apiserver-minikube            1/1     Running   1          20h
                              kube-controller-manager-minikube   1/1     Running   2          20h
                              kube-proxy-tgrtl                   1/1     Running   1          20h
                              kube-scheduler-minikube            1/1     Running   2          20h
                              storage-provisioner                1/1     Running   3          20h

* Creating a namespace from a YAML file

  apiVersion: v1
  kind: Namespace
  metadata:
    name: custom-namespace

  send file to k8 API          $ kubectl create -f custom-namespace.yaml

* Creating a namespace with kubectl create namespace

  use command line              $ kubectl create namespace custom-namespace
                                NOTE Although most objects’ names must conform to the naming conventions
                                specified in RFC 1035 (Domain names), which means they may contain
                                only letters, digits, dashes, and dots, namespaces (and a few others) aren’t
                                allowed to contain dots.

* Although namespaces allow you to isolate objects
into distinct groups, which allows you to operate only on those belonging to the specified
namespace, they don’t provide any kind of isolation of running objects.

## 3.8 Stopping and removing pods

* list pods                   $ kubectl get pod
                              NAME             READY   STATUS             RESTARTS   AGE
                              kubia-67tkh      0/1     ImagePullBackOff   0          152m
                              kubia-6mnfq      0/1     ImagePullBackOff   0          152m
                              kubia-flc75      0/1     ImagePullBackOff   0          152m
                              kubia-jqm88      0/1     ErrImagePull       0          152m
                              kubia-manual     0/1     ImagePullBackOff   0          3h2m
                              kubia-manual-b   0/1     ImagePullBackOff   0          167m

* delete pods                 $ kubectl delete po manual
                              $ kubectl delete po kubia-manual-b

* delete scaled pods          $ kubectl scale rc kubia --replicas=0

* delete using lable          $ kubectl delete po -l creation_method=manual
                              $ kubectl delete po -l creation_method=manual

* delete namespace and pods   $ kubectl delete ns custom-namespace

* delete all pods in ns       $ kubectl delete po --all

* delete most resource in ns  $ kubectl delete po --all

# Chapter 4: Replication and other controllers: deploying managed pods

## 4.1 Keeping pods healthy

* pods represent the basic deployable unit in Kubernetes

* ReplicationControllers or Deployments, create and manage the actual pods.

* liveness probe
  * Kubernetes can check if a container is still alive
  * Method #1: An HTTP GET probe performs an HTTP GET request on the container’s IP
    address, a port and path you specify.
  * Method: #2: A TCP Socket probe tries to open a TCP connection to the specified port of the
    container.
  * Method #3: An Exec probe executes an arbitrary command inside the container and checks
    the command’s exit status code.

## Example Session: Liveness Probe
### TODO

? * load container on prod        $ kubectl run kubia-liveness --image=luksa/kubia-unhealthy --port=8080 --generator=run/v1
? or
? * load container on prod        $ kubectl run kubia-liveness --image=luksa/kubia-unhealthy --port=8080 --generator=run-pod/v1
? 
? * check liveness                $ kubectl get po kubia-liveness-b5b6r
? 
? * create service object         $ kubectl expose rc kubia-liveness --type=LoadBalancer --name kubia-liveness-http
? 
? * get service                   $ kubectl get services
?                                 kubia-liveness-http   LoadBalancer   10.109.75.232   <pending>     8080:32180/TCP   20s
?                                 http://10.109.75.232/
?                                 Access to this website violates the corporate Internet policy
?                                 curl http://10.109.75.232/


* liveness probe in action      $ kubectl get po kubia-liveness
                                NAME            READY  STATUS   RESTARTS  AGE
                                kubia-liveness  1/1    Running  1         2m

* look at previous logs         $ kubectl logs mypod --previous

* exit code
  * 137 - corresponds to 128 + 9  (SIGKILL)
  * 143 - corresponds to 128 + 15 (SIGTERM) 

* Always remember to set an initial delay to account for your app’s startup time.

* For pods running in production, you should always define a liveness probe
  * simplistic liveness probe simply checks if the server is responding
  * configure the probe to perform requests on a specific URL path (/health, for example)
  * Make sure doesn’t require authentication
  * check only the internals of the app and nothing influenced by an external factor.
  * shouldn’t use too many computational resources
  * shouldn’t take too long to complete.
  * executed relatively often and are only allowed one second to complete.
  * for Java, use HTTP GET and don't use an Exec probe (where you spin up a whole new JVM)
  * don't bother with retry loop, already becked in

## 4.2 Introducing ReplicationControllers

* ReplicationControllers
  * is a Kubernetes resource that ensures its pods are always kept running
  * monitors the list of running pods and makes sure the actual number of pods
    of a “type” always matches the desired number.

* 3 parts
  * A label selector, determines what pods are in the ReplicationController’s scope
  * A replica count, specifies the desired number of pods that should be running
  * A pod template, used when creating new pod replicas

* Changing the label selector makes the existing pods fall out of the scope

* template only affects new pods created by this ReplicationController

* When node fails, ReplicationController creates replacement replicas for all the pods

* enables easy horizontal scaling of pods 

* the ReplicationController creates a completely new pod instance

## Example Session: Create a ReplicationController using JSON or YAML file
### TODO

* First, need to revert work previously done ...
* list ReplicationControllers   $ kubectl get rc
                                NAME             DESIRED   CURRENT   READY   AGE
                                kubia            0         0         0       4d10h
                                kubia-liveness   1         1         1       20h
* delete ReplicationController  $ kubectl delete rc kubia


* create a ReplicationController using JSON or YAML descriptor
*   file definition
                                apiVersion: v1
                                kind: ReplicationController
                                metadata:
                                  name: kubia
                                spec:
                                  replicas: 3
                                  selector:
                                    app: kubia
                                  
                                    metadata:
                                      labels:template:
                                        app: kubia
                                    spec:
                                      containers:
                                      - name: kubia
                                        image: luksa/kubia
                                        ports:
                                        - containerPort: 8080

*   cmd to create rc            $ kubectl create -f kubia-rc.yaml

*   confirm created             $ kubectl get rc
                                NAME             DESIRED   CURRENT   READY   AGE
                                kubia            3         3         3       87s

*   confirm pods exists         $ kubectl get pods
                                NAME                   READY   STATUS    RESTARTS   AGE
                                kubia-cb8bn            1/1     Running   0          13s
                                kubia-kndkd            1/1     Running   0          13s
                                kubia-zqp48            1/1     Running   0          13s


* Simulating node failure using  Google Kubernetes Engine 
*   list pods                       $ kubectl get nodes -o wide
*   ssh into one of the nodes       $ gcloud compute ssh gke-kubia-default-pool-b46381f1-zwko
*   sudo ifconfig eth0 down         $ sudo ifconfig eth0 down
*   In new terminal list the nodes  $ kubectl get node
*   To bring the node back          $ gcloud compute instances reset gke-kubia-default-pool-b46381f1-zwko

* ReplicationController manages pods that match its label selector

* Changing a pod’s labels can result in it being removed from or added to the scope of a ReplicationController

* display pod labels                 $ kubectl get pods --show-labels

* add a label on pod                 $ kubectl label pod kubia-dmdck type=special
                                     $ kubectl get pods --show-labels

* delete a label on pod              $ kubectl label pod kubia-dmdck type-
                                     $ kubectl get pods --show-labels

* change an existing label           $ kubectl label pod kubia-dmdck app=foo --overwrite
                                     $ kubectl get pods --show-labels

* display column KEY VALUE's         $ kubectl get pods -L app

* A reason to take a pod out of a ReplicationController is to debug it separately.

* Modify a ReplicationController's label Selector and all pods go out of scope

* A ReplicationController’s pod template can be modified at any time.

* show rc Selector label              $ kubectl describe rc
                                      Name:         kubia
                                      Namespace:    default
                                      Selector:     app=kubia
                                      Labels:       app=kubia
                                      ...

* edit ReplicationController          $ kubectl edit rc kubia
  and add 2nd label "type: square"    ...
                                      template:
                                        metadata:
                                          creationTimestamp: null
                                          labels:
                                            app: kubia
                                            type: square
                                      ...

* Horizontally scaling pods

  * scale up, --replicas         $ kubectl scale rc kubia --replicas=10
  or
  * scale up, spec.replicas      $ kubectl edit rc kubia
                                      spec:
                                        replicas: 10
  * scale down                   $ kubectl scale rc kubia --replicas=3

* Use ReplicaSet instead of ReplicationController (deprecated)
  * Has more expressive pod selectors.
  * Allows matching pods that lack a certain label
  * Include a certain label key, regardless of its value.
  * Can select using multiple labels
  * aren’t part of the v1 API
  * old - spec.selector (ReplicationController)
    vs 
    new - spec.selector.matchLabels (ReplicaSet)

  * apiVersion (property)
    * <resource>.apiVersion           // Valid for all resources 
    * Defines the versioned schema of this representation of an object
    * <api-group>/<api-version>       // example ReplicaSet "apps/v1beta2"

  * matchLabels (property)
    * ReplicaSet.spec.selector.matchLabels
    * matchLabels is a map of {key,value} pairs
    * <key>: <value>                  // example: "app: kubia"

* delete rc & keep pods running   $ kubectl delete rc kubia --cascade=false

## 4.3 Using ReplicaSets instead of ReplicationControllers

## Example Session: Create ReplicaSets (instead of ReplicationControllers)
### TODO

* create ReplicaSet               $ kubectl create -f kubia-replicaset.yaml
                                  replicaset.apps/kubia created

* list ReplicaSet                 $ kubectl get rs
                                  NAME    DESIRED   CURRENT   READY   AGE
                                  kubia   3         3         3       36m

* add label                       kubectl edit rs kubia
                                  Labels: app=kubia

* describe ReplicaSet             $ kubectl describe rs
                                  Name:         kubia
                                  Namespace:    default
                                  Selector:     app=kubia
                                  Labels:       <none>              # book says "Labels: app=kubia"
                                  Annotations:  <none>
                                  Replicas:     3 current / 3 desired
                                  Pods Status:  3 Running / 0 Waiting / 0 Succeeded / 0 Failed
                                  Pod Template:
                                    Labels:  app=kubia
                                    Containers:
                                     kubia:
                                      Image:        luksa/kubia
                                      Port:         <none>
                                      Host Port:    <none>
                                      Environment:  <none>
                                      Mounts:       <none>
                                    Volumes:        <none>
                                  Events:           <none>

* kubia-replicaset-matchexpressions.yaml
  selector:
    matchExpressions:
      - key: app
        operator: In
        values:
         - kubia

* valid operators
  * In           — Label’s value must match one of the specified values.
  * NotIn        — Label’s value must not match any of the specified values.
  * Exists       — Pod must include a label with the specified key (the value
                   isn’t important). When using this operator, you shouldn’t
                   specify the values field.
  * DoesNotExist — Pod must not include a label with the specified key. The 
                   values property must not be specified.

* delete rc (and pods)          $ kubectl delete rs kubia
                                NAME                   READY   STATUS        RESTARTS   AGE
                                kubia-h54z4            1/1     Terminating   0          21h
                                kubia-liveness-b5b6r   1/1     Running       1          45h
                                kubia-q9bhk            1/1     Terminating   0          21h
                                kubia-r7r9z            1/1     Terminating   0          21h

## 4.4 Running exactly one pod on each node with DaemonSets

* DaemonSet represents the configuration of a daemon set.

* Use when
  * want a pod to run on each and every node in the cluster
  * and each node needs to run exactly one instance of the pod
* Example
  * Run a log collector and a resource monitor on every node
  * Kubernetes’ own kube-proxy process, which needs to run on all nodes to make services work

* ReplicaSets vs DaemonSets 
  * ReplicaSets scatter pods around the whole cluster randomly
  * DaemonSets run only a single pod replica on each node

* Use node-Selector property to run on some nodes

* DaemonSet will deploy pods unscheduled nodes

## Example Session: DaemonSet
### TODO

* create ssd DeamonSet          $ kubectl create -f ssd-monitor-daemonset.yaml
                                daemonset.apps/ssd-monitor created

* list DeamonSet                $ kubectl get ds
                                NAME          DESIRED   CURRENT   READY   UP-TO-DATE   AVAILABLE   NODE SELECTOR   AGE
                                ssd-monitor   0         0         0       0            0           disk=ssd        2m53s
                                

* describe DaemonSet            $ kubectl describe ds
                                Name:           ssd-monitor
                                Selector:       app=ssd-monitor
                                Node-Selector:  disk=ssd
                                Labels:         <none>
                                Annotations:    deprecated.daemonset.template.generation: 1
                                Desired Number of Nodes Scheduled: 0
                                Current Number of Nodes Scheduled: 0
                                Number of Nodes Scheduled with Up-to-date Pods: 0
                                Number of Nodes Scheduled with Available Pods: 0
                                Number of Nodes Misscheduled: 0
                                Pods Status:  0 Running / 0 Waiting / 0 Succeeded / 0 Failed
                                Pod Template:
                                  Labels:  app=ssd-monitor
                                  Containers:
                                   main:
                                    Image:        luksa/ssd-monitor
                                    Port:         <none>
                                    Host Port:    <none>
                                    Environment:  <none>
                                    Mounts:       <none>
                                  Volumes:        <none>
                                Events:           <none>

* list node                     $ kubectl get node
                                NAME       STATUS   ROLES    AGE     VERSION
                                minikube   Ready    master   5d17h   v1.16.2

* add label to node             $ kubectl label node minikube disk=ssd

* see created pod               $ kubectl get po

* remove label                  $ kubectl label node minikube disk=hdd --overwrite

## 4.5 Running pods that perform a single completable task

* Job represents the configuration of a single job.

* ReplicationControllers, ReplicaSets, and DaemonSets
  * Pods all run continuously

* Job resource
  * Pod runs once and ends on completion
  * If node fails, pod is rescheduled to other nodes
  * If process fails, can be configured to restart or not restart

* spec.restartPolicy sets the policy
  spec:
    restartPolicy: OnFailure

## Example Session: Jobs
### TODO

* list jobs (not yet created)   $ kubectl get jobs

* list pods (not yet created)   $ kubectl get po

* create job                    $ kubectl create -f exporter.yaml
                                job.batch/batch-job created

* list jobs (creation)          $ kubectl get jobs
                                NAME        COMPLETIONS   DURATION   AGE
                                batch-job   0/1           8s         8s

* list pods (creation)          $ kubectl get po
                                NAME                   READY   STATUS    RESTARTS   AGE
                                batch-job-dc2cl        1/1     Running   0          42s

* The reason the pod isn’t deleted when it completes is to allow you
  to examine its logs

* show logs                     $ kubectl logs batch-job-dc2cl
                                Wed Oct 30 21:15:07 UTC 2019 Batch job starting
                                Wed Oct 30 21:17:07 UTC 2019 Finished succesfully

* list jobs (complete)          $ kubectl get jobs                              # Different than in book.
                                NAME        COMPLETIONS   DURATION   AGE
                                batch-job   1/1           2m5s       3m11s

* list pods (complete)          $ kubectl get po
                                NAME                   READY   STATUS      RESTARTS   AGE
                                batch-job-dc2cl        0/1     Completed   0          3m42s

* delete job                    $ kubectl delete jobs batch-job

* Use spec.completions to set number of times to complete sequentially
                                apiVersion: batch/v1
                                kind: Job
                                metadata:
                                  name: multi-completion-batch-job
                                spec:
                                  completions: 5
                                ...

* Use job.spec.parallelism to run pods in parallel
                                apiVersion: batch/v1
                                kind: Job
                                metadata:
                                  name: multi-completion-batch-job
                                spec:
                                  completions: 5
                                  parallelism: 2
                                ...

* change parallelism            $ kubectl scale job multi-completion-batch-job --replicas 3

* parallelism (property)
  * job.spec.parallelism
  * Specifies the maximum desired number of pods the job should run at any
    given time.
  * Can change while the Job is running
  * integer value

* activeDeadlineSeconds (property)
  * pod.spec.activeDeadlineSeconds
  * Optional duration before pod is mark failed and kill
  * positive integer value


* job's spec.backoffLimit - configure how many times a Job can be retried before it is marked as failed

## 4.6 Scheduling Jobs to run periodically or once in the future

* A cron job in Kubernetes is configured by creating a CronJob resource.

* list CronJob  (not created)   $ kubectl get cronjob 

* create CronJob                $ kubectl create -f cronjob.yaml

* list CronJob  (createded)     $ kubectl get cronjob 
                                NAME                              SCHEDULE             SUSPEND   ACTIVE   LAST SCHEDULE   AGE
                                batch-job-every-fifteen-minutes   0,15,30,45 * * * *   False     0        <none>          7s

* delete Chronmob               $ kubectl delete cronjob batch-job-every-fifteen-minutes
                                cronjob.batch "batch-job-every-fifteen-minutes" deleted

* CronJob spec.startingDeadlineSeconds - requirement for the job to not be started too far over the scheduled time

* Running Cronjob multiple times instead of once shouldn’t lead to unwanted results (idempotent)

* Make sure that the next job run performs any work that should have been done by the previous (missed) run.

# Chapter 5: Services: enabling clients to discover and talk to pods

## 5.1 Introducing services

* Not able to assign a static address to pods because:
  * Pods are ephemeral
  * Kubernetes assigns an IP address to a pod after the pod has been
    scheduled to a node and before it’s started
  * Horizontal scaling means multiple pods may provide the same service

* Services
  * A resource you create to make a single, constant point of entry to
    a group of pods providing the same service.
  * Each service has an IP address and port that never change while the
    service exists.

* An example
  * External clients need to connect to the frontend pods without
    caring if there’s only a single web server or hundreds.
  * The frontend pods need to connect to the backend database.
  * The service address doesn’t change even if the pod’s IP address changes.

* Can find service by its name through either environment variables or DNS.

* Both internal and external clients usually connect to pods through services.

* Label selectors determine which pods belong to the Service.

* The primary purpose of services is exposing groups of pods to other
  pods in the cluster.

### Method #1: Create a service via "kubectl expose" or file

Example from Chapter 2:

* expose ip address              $ kubectl expose rc kubia --type=LoadBalancer --name kubia-http
                                 service/kubia-http exposed

### Method #2: Creating a service through a yaml descriptor

* create service via yaml file   $ kubectl create -f kubia-svc.yaml
  (See example below)            service/kubia created

### Testing service from within the cluster
  1. Create a pod that will send the request to the service’s cluster IP and log the response.
  2. ssh into one of the Kubernetes nodes and use the curl command
  3. Execute the curl command inside one of your existing pods through the kubectl exec command.

* remotely examine service       $ kubectl exec kubia -- curl -s http://10.106.53.136
                                 

### kubectl exec -- curl
   * Allows you to remotely run arbitrary commands inside an existing container of a pod.
 
   * Double dash (--) specifies end of kubectl cmds and beginning of cmds for pod

### Session affinity property

* sessionAffinity (property)
  * service.spec.sessionAffinity
  * Used to maintain session affinity (natural liking)
  * ClientIP    Requests go to the same pod
  * None        Requests go to different pods; default

* There is no cookie-based session affinity option. This is because Services
  don’t operate at the HTTP level. Services deal with TCP and UDP packets.

### Exposing multiple ports

   * Services can also support multiple ports, i.e,
     * 8080 for HTTP
     * 8443 for HTTPS
     * Must specify name for each port

       spec:
         ports:
         - name: http
           port: 80
           targetPort: 8080
         - name: https
           port: 443
           targetPort: 8443
         selector:
           app: kubia

### Using named ports

   * Can also give a name to each pod’s port and refer to it by name in the service spec.
     Enables you to change port numbers later without having to change the service spec.

     kind: Pod
     spec:
       containers:
       - name: kubia
         ports:
         - name: http
           containerPort: 8080
         - name: https
           containerPort: 8443

     kind: Service
     spec:
       ports:
       - name: http
         port: 80
         targetPort: http
       - name: https
         port: 443
         targetPort: https

### Discovering services through environment variables

* Environment variables exists for each of the service in each of the pods.

* The environment variables are available even before the pod is status=running

* KUBIA_SERVICE_HOST and KUBIA_SERVICE_PORT hold the IP address and port of the service

  $ kubectl exec <pod-name> -- env | sort
  ...
  KUBIA_SERVICE_HOST=10.111.125.123
  KUBIA_SERVICE_PORT=80
  ...

* You can expose the backend pod through a service called backend-database and then
  have the frontend pod look up its IP address and port through the environment variables
  BACKEND_DATABASE_SERVICE_HOST and BACKEND_DATABASE_SERVICE_PORT.

* Dashes in the service name are converted to underscores and all letters
  are uppercased when the service name is used as the prefix in the environment
  variable’s name.

### Example Session: ReplicationController + 3 pods + Service via file (kubia-svc.yaml)

* Docker login                   $ docker login
                                 Authenticating with existing credentials...
                                 Login Succeeded

* create Replication Controller  Create a Replication Controller that creates a Pod containing the deployed Container
                                 $ kubectl run kubia --image=benjamintiddlefundingcircle/kubia --port=8080 --generator=run/v1
                                 replicationcontroller/kubia created

* scale Replication Controller   Create additional Replication Controllers to create more Pods 
                                 $ kubectl scale rc kubia --replicas=3
                                 replicationcontroller/kubia scaled

* configure internal IP          Create a Service that configures the internal IP address for the Pods
  address (via YAML file)        $ kubectl create -f kubia-svc.yaml
                                 service/kubia created

* restart pods (to pick up       $ kubectl delete pods --all
  internal IP address
  configured by Service)

* list rc, svs and pods          $ kubectl get -o wide --show-labels replicationcontroller
                                 NAME    DESIRED   CURRENT   READY   AGE   CONTAINERS   IMAGES                              SELECTOR    LABELS
                                 kubia   3         3         3       73m   kubia        benjamintiddlefundingcircle/kubia   run=kubia   run=kubia
                                 
                                 $ kubectl get -o wide --show-labels pods
                                 NAME          READY   STATUS    RESTARTS   AGE   IP           NODE             NOMINATED NODE   READINESS GATES   LABELS
                                 kubia-8vprs   1/1     Running   0          73m   10.1.2.170   docker-desktop   <none>           <none>            run=kubia
                                 kubia-b2fxv   1/1     Running   0          73m   10.1.2.168   docker-desktop   <none>           <none>            run=kubia
                                 kubia-zc7vs   1/1     Running   0          73m   10.1.2.169   docker-desktop   <none>           <none>            run=kubia

                                 $ kubectl get -o wide --show-labels services
                                 NAME         TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)   AGE    SELECTOR    LABELS
                                 kubernetes   ClusterIP   10.96.0.1        <none>        443/TCP   132d   <none>      component=apiserver,provider=kubernetes
                                 kubia        ClusterIP   10.108.250.163   <none>        80/TCP    72m    run=kubia   <none>
                                                                  
* remotely execute cmds in pod   $ kubectl exec kubia-8vprs -- hostname
  *  exec hostname               kubia-8vpr
                                 $ kubectl exec kubia-b2fxv -- hostname
                                 kubia-b2fxv
                                 $ kubectl exec kubia-zc7vs -- hostname
                                 kubia-zc7vs

  * Note: kubia-svc.yaml         $ kubectl exec <POD-NAME> -- curl -s http://<SERVICE-CLUSTER-IP>
                                 Had to replace selector.app=kubia with selector.run=kubia
                                 so that replicationcontroller and pod labels are in sync. This change 
                                 eliminates, "Error: command terminated with exit code 7" when doing

  * exec curl                    $ kubectl exec kubia-8vprs -- curl -s http://10.108.250.163
                                 You've hit kubia-8vprs

                                 $ kubectl exec kubia-b2fxv -- curl -s http://10.108.250.163
                                 You've hit kubia-b2fxv

                                 $ kubectl exec kubia-zc7vs -- curl -s http://10.108.250.163
                                 You've hit kubia-zc7vs

  * exec env                     $ kubectl exec kubia-zc7vs -- env | sort
                                 HOME=/root
                                 HOSTNAME=kubia-zc7vs
                                 KUBERNETES_PORT=tcp://10.96.0.1:443
                                 KUBERNETES_PORT_443_TCP=tcp://10.96.0.1:443
                                 KUBERNETES_PORT_443_TCP_ADDR=10.96.0.1
                                 KUBERNETES_PORT_443_TCP_PORT=443
                                 KUBERNETES_PORT_443_TCP_PROTO=tcp
                                 KUBERNETES_SERVICE_HOST=10.96.0.1
                                 KUBERNETES_SERVICE_PORT=443
                                 KUBERNETES_SERVICE_PORT_HTTPS=443
                                 KUBIA_PORT=tcp://10.108.250.163:80
                                 KUBIA_PORT_80_TCP=tcp://10.108.250.163:80
                                 KUBIA_PORT_80_TCP_ADDR=10.108.250.163
                                 KUBIA_PORT_80_TCP_PORT=80
                                 KUBIA_PORT_80_TCP_PROTO=tcp
                                 KUBIA_SERVICE_HOST=10.108.250.163
                                 KUBIA_SERVICE_PORT=80
                                 NODE_VERSION=7.10.1
                                 NPM_CONFIG_LOGLEVEL=info
                                 PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
                                 YARN_VERSION=0.24.4

### Discovering services through DNS

* To revisit the frontend-backend example, a frontend pod can connect to the 
  backenddatabase service by opening a connection to the following FQDN:

  backend-database.default.svc.cluster.local

  backend-database     Corresponds to the service name
  default              Stands for the namespace the service is defined in
  svc.cluster.local    Is a configurable cluster domain suffix used in
                       all cluster local service names.

  standard ports       80   for HTTP
                       5432 for Postgres
  non-std              Cient can get the port number from the env var

  Can omit the namespace and svc.cluster.local suffix, when the frontend pod is
  in the same namespace as the database pod.

### Example: Hit your service by using the service’s name as the hostname 

* list pods                      $ kubectl get -o wide --show-labels pods
                                 NAME          READY   STATUS    RESTARTS   AGE     IP           NODE             NOMINATED NODE   READINESS GATES   LABELS
                                 kubia-8vprs   1/1     Running   0          3h46m   10.1.2.170   docker-desktop   <none>           <none>            run=kubia
                                 kubia-b2fxv   1/1     Running   0          3h46m   10.1.2.168   docker-desktop   <none>           <none>            run=kubia
                                 kubia-zc7vs   1/1     Running   0          3h46m   10.1.2.169   docker-desktop   <none>           <none>            run=kubia

* run shell in a pod             $ kubectl exec -it kubia-8vprs bash
                                 root@kubia-8vprs:/#

* access the service             $ curl http://kubia.default.svc.cluster.local
                                 You've hit kubia-b2fxv
                                 $ curl http://kubia.default
                                 You've hit kubia-8vprs
                                 $ curl http://kubia
                                 You've hit kubia-zc7vs

* view config file               $ cat /etc/resolv.conf
                                 nameserver 10.96.0.10
                                 search default.svc.cluster.local svc.cluster.local cluster.local
                                 options ndots:5

* ping service                   $ ping kubia
  Can not do because service’s   PING kubia.default.svc.cluster.local (10.108.250.163): 56 data bytes
  cluster IP is a virtual IP.    ^C--- kubia.default.svc.cluster.local ping statistics ---
                                 56 packets transmitted, 0 packets received, 100% packet loss


## 5.2 Connecting to services living outside the cluster

### Service endpoints

* Want it to redirect to external IP(s) and port(s)

* Take advantage of both service load balancing and service discovery.

* Services don’t link to pods directly. Instead, a resource sits in 
  between called the Endpoints resource.

* describe to see svc endpoints  $ kubectl describe svc kubia
                                 Name:              kubia
                                 Namespace:         default
                                 Labels:            <none>
                                 Annotations:       <none>
                                 Selector:          run=kubia
                                 Type:              ClusterIP
                                 IP:                10.108.250.163
                                 Port:              <unset>  80/TCP
                                 TargetPort:        8080/TCP
                                 Endpoints:         10.1.2.168:8080,10.1.2.169:8080,10.1.2.170:8080
                                 Session Affinity:  None
                                 Events:            <none>

* list endpoints                 $ kubectl get endpoints kubia
                                 NAME    ENDPOINTS                                         AGE
                                 kubia   10.1.2.168:8080,10.1.2.169:8080,10.1.2.170:8080   4h28m

### Manually configuring endpoints

* The Endpoints object needs to have the same name as the service and 
  contain the list of target IP addresses and ports for the service.

* If you later decide to migrate the external service to pods running 
  inside Kubernetes, you can add a selector to the service, thereby
  making its Endpoints managed automatically.

* service yaml                   $ cat external-service.yaml
                                 apiVersion: v1
                                 kind: Service
                                 metadata:
                                   name: external-service
                                 spec:
                                   ports:
                                   - port: 80

* create svc w/o a selector      $ kubectl create -f external-service.yaml
                                 service/external-service created
                                 $ kubectl get services external-service
                                 NAME               TYPE        CLUSTER-IP     EXTERNAL-IP   PORT(S)   AGE
                                 external-service   ClusterIP   10.96.19.219   <none>        80/TCP    74s

* endpoint yaml                 $ cat external-service-endpoints.yaml
                                apiVersion: v1
                                kind: Endpoints
                                metadata:
                                  name: external-service
                                subsets:
                                  - addresses:
                                    - ip: 11.11.11.11
                                    - ip: 22.22.22.22
                                    ports:
                                    - port: 80 

* create endpoint resource      $ kubectl create -f external-service-endpoints.yaml
                                endpoints/external-service created

### Creating an alias for an external service

* Refer to an external service by its fully qualified domain name (FQDN).

* Create a Service resource with the type field set to ExternalName.

* A CNAME record points to a fully qualified domain name instead of a numeric
  IP address.

* service yaml                   $ cat external-service-externalname.yaml
                                 apiVersion: v1
                                 kind: Service
                                 metadata:
                                   name: external-service
                                 spec:
                                   type: ExternalName
                                   externalName: api.somecompany.com
                                   ports:
                                   - port: 80

* pods can connect using         $ curl http://external-service.default.svc.cluster.local

## 5.3 Exposing services to external clients

* Will want to expose certain services, such as frontend webservers,
  to the outside, so external clients can access them.

* Can do by:
  * Setting the service type to NodePort
  * Setting the service type to LoadBalancer (a NodePort type)
  * Creating an Ingress resource

* type (property) 
  * service.spec.type
  * Determines how the Service is exposed.
  * ClusterIP        Allocates a cluster-internal IP address for load-balancing to endpoints; default
  * ExternalName     Maps to the specified externalName
  * NodePort         Builds on ClusterIP and allocates a port on every node which routes to the clusterIP
  * LoadBalancer     Builds on NodePort and creates an external load-balancer

### Using a NodePort service

* Will need to mess with firewalls settings.

* nodeport yaml                  $ cat kubia-svc-nodeport.yaml
                                 apiVersion: v1
                                 kind: Service
                                 metadata:
                                   name: kubia-nodeport
                                 spec:
                                   type: NodePort
                                   ports:
                                   - port: 80              // internal cluster IP
                                     targetPort: 8080      // target port of the backing pods
                                     nodePort: 30123       // service accessible to each cluster node
                                   selector:
                                     run: kubia            // changed from "app: kubia" to "run: kubia"

* create nodeport                $ kubectl create -f kubia-svc-nodeport.yaml
                                 service/kubia-nodeport created

* check noteport                 $ kubectl get svc kubia-nodeport
                                 NAME             TYPE       CLUSTER-IP     EXTERNAL-IP   PORT(S)        AGE
                                 kubia-nodeport   NodePort   10.108.66.68   <none>        80:30123/TCP   81s
                                 Note: Book says should be "EXTERNAL-IP <nodes>"

* list open ports on mac        $ lsof -nP +c 15 | grep LISTEN
                                sft               525 benjamin.tiddle    8u     IPv4 0x80d8878fea8916ff         0t0        TCP 127.0.0.1:49157 (LISTEN)
                                com.docker.supe   708 benjamin.tiddle    7u     IPv4 0x80d8878ff0fc107f         0t0        TCP 127.0.0.1:49171 (LISTEN)
                                com.docker.back   716 benjamin.tiddle   14u     IPv4 0x80d8879013f439ff         0t0        TCP 127.0.0.1:6443 (LISTEN)
                                com.docker.back   716 benjamin.tiddle   19u     IPv6 0x80d8878fe6642c3f         0t0        TCP \*:30123 (LISTEN)
                                Note: https://wilsonmar.github.io/ports-open/

### JSONPath to get the IPs of all your nodes

kubectl get nodes -o jsonpath='{.items[*].status.status.addresses[?(@.type=="ExternalIP")].address}'

  • Go through all the elements in the items attribute.
  • For each element, enter the status attribute.
  • Filter elements of the addresses attribute, taking only those that have the
    type attribute set to ExternalIP.
  • Finally, print the address attribute of the filtered elements.
  • http://kubernetes.io/docs/user-guide/jsonpath


### Exposing a service through an external load balancer

* Didn’t need to mess with firewalls settings.

* In the browser, even if session affinity is set to None, users will
  always hit the same pod (until the connection is closed) because the
  browser is using keep-alive connections

* load balancer yaml             $ cat kubia-svc-loadbalancer.yaml
                                 apiVersion: v1
                                 kind: Service
                                 metadata:
                                   name: kubia-loadbalancer
                                 spec:
                                   type: LoadBalancer     // set to LoadBalancer instead of NodePort
                                   ports:
                                   - port: 80
                                     targetPort: 8080
                                   selector:
                                     run: kubia           // changed from "app: kubia" to "run: kubia"

* create load balancer           $ kubectl create -f kubia-svc-loadbalancer.yaml
                                 service/kubia-loadbalancer created

* check noteport                 $ kubectl get svc kubia-nodeport

* list load balancer             $ kubectl get -o wide --show-labels svc kubia-loadbalancer
                                 NAME                 TYPE           CLUSTER-IP     EXTERNAL-IP   PORT(S)        AGE     SELECTOR    LABELS
                                 kubia-loadbalancer   LoadBalancer   10.99.46.186   localhost     80:30138/TCP   4m17s   run=kubia   <none>

* can connect using              $ curl http://localhost
                                 or
                                 $ curl http://localhost:80
                                 You've hit kubia-j2w7h

### Understanding and preventing unnecessary network hops

* Prevent additional hop by configuring the service to redirect external
  traffic only to pods running on the node that received the connection.

* Will hand if node does not have a working pod.

* A Service using the Local external traffic policy may lead to uneven
  load distribution across pods.

* Be aware of the non-perservation of the client's IP

* ymal entry                     spec:
                                   externalTrafficPolicy: Local
                                   ...

## 5.4 Exposing services externally through an Ingress resource

* Ingress (noun)— The act of going in or entering; the right to enter;
  a means or place of entering; entryway.

* LoadBalancer service requires its own load balancer with its own public IP
  address, whereas an Ingress only requires one, even when providing access to
  dozens of services.

* Ingresses operate at the application layer of the network stack (HTTP) and
  can provide features such as cookie-based session affinity and the like, 
  which services can’t.

* Ingress controller didn’t forward the request to the service. It only used it
  to select a pod. Most, if not all, controllers work like this.

* verify ingresses controller    $ kubectl get po --all-namespaces

* ingress yaml                   $ cat kubia-ingress.yaml
                                 apiVersion: extensions/v1beta1
                                 kind: Ingress
                                 metadata:
                                   name: kubia
                                 spec:
                                   rules:
                                   - host: kubia.example.com
                                     http:
                                       paths:
                                       - path: /
                                         backend:
                                           serviceName: kubia-nodeport
                                           servicePort: 80

* create ingress                 $ kubectl create -f kubia-ingress.yaml
                                 ingress.extensions/kubia created

* list ingresses                 $ kubectl get ingresses
                                 NAME    HOSTS               ADDRESS          PORTS   AGE
                                 kubia   kubia.example.com                    80      22m

                                 Note: "ADDRESS" did not ever appear in my local setup. Not sure why, so continuing with book example.
                                 NAME    HOSTS               ADDRESS          PORTS  AGE
                                 kubia   kubia.example.com   192.168.99.100   80     29m

* configure your DNS servers     192.168.99.100 kubia.example.com
  to resolve kubia.example.com
  to that IP or update
  file /etc/hosts file

* access pods thru ingress       $ curl http://kubia.example.com
                                 You've hit kubia-ke823

### Exposing multiple services through the same Ingress

* yaml entry                     ...
                                   - host: kubia.example.com
                                     http:
                                     paths:
                                     - path: /kubia           // Requests to kubia.example.com/kubia
                                       backend:               // will be routed to the kubia service.
                                         serviceName: kubia   
                                         servicePort: 80      
                                     - path: /bar             // Requests to kubia.example.com/bar
                                       backend:               // will be routed to the bar service.
                                         serviceName: bar     
                                         servicePort: 80      

* create load balancer           $ kubectl create -f kubia-svc-loadbalancer.yaml

### Mapping different services to different hosts

* You can use an Ingress to map to different services based on the host
  in the HTTP request instead of (only) the path.

* DNS needs to point both the foo.example.com and the bar.example.com domain
  names to the Ingress controller’s IP address.

* yaml entry                     ...
                                 spec:
                                   rules:
                                   - host: foo.example.com   // Requests for foo.example.com will be routed to service foo.
                                     http:
                                       paths:
                                       - path: /
                                         backend:
                                           serviceName: foo
                                           servicePort: 80
                                   - host: bar.example.com   // Requests for bar.example.com will be routed to service bar.
                                     http:
                                       paths:
                                       - path: /
                                         backend:
                                           serviceName: bar
                                           servicePort: 80

### Configuring Ingress to handle TLS (HTTPS) traffic

* create private key             $ openssl genrsa -out tls.key 2048

* create certificate             $ openssl req -new -x509 -key tls.key -out tls.cert -days 360 -subj /CN=kubia.example.com

* create the Secret              $ kubectl create secret tls tls-secret --cert=tls.cert --key=tls.key
                                 secret "tls-secret" created

* signing certificates           $ kubectl certificate approve <name of the CSR>
  See page 148 for details.

* Update Ingress object          apiVersion: extensions/v1beta1
                                 kind: Ingress
                                 metadata:
                                   name: kubia
                                 spec:
                                   tls:
                                   - hosts: 
                                     - kubia.example.com
                                     secretName: tls-secret
                                   rules:
                                   - host: kubia.example.com
                                     http:
                                       paths:
                                       - path: /
                                         backend:
                                           serviceName: kubia-nodeport
                                           servicePort: 80

* apply change                   $ kubectl apply -f kubia-ingress-tls.yaml,

* use HTTPS to access service    $ curl -k -v https://kubia.example.com/kubia
                                 About to connect() to kubia.example.com port 443 (#0)
                                 ...
                                 * Server certificate:
                                 * subject: CN=kubia.example.com
                                 ...
                                 > GET /kubia HTTP/1.1
                                 > ...
                                 You've hit kubia-xueq1

### Signaling when a pod is ready to accept connections

* Pods are included as endpoints of a service if their labels match the 
  service’s pod selector.

* It makes sense to not forward requests to a pod that’s in the process
  of starting up until it’s fully ready.

* liveness probes - Unhealthy containers are killed and recreated 
  automatically. Liveness probes keep pods healthy by killing off
  unhealthy containers and replacing them with new, healthy ones.

* readiness probe - If a pod reports that it’s not ready, it’s removed from the
  service. If the pod then becomes ready again, it’s re-added. Readiness probes
  make sure that only pods that are ready to serve requests receive them.

* Types of readiness probes
  * An Exec probe, where a process is executed. The container’s status is
    determined by the process’ exit status code.
  * An HTTP GET probe, which sends an HTTP GET request to the container and
    the HTTP status code of the response determines whether the container is
    ready or not.
  * A TCP Socket probe, which opens a TCP connection to a specified port of the
    container. If the connection is established, the container is considered
    ready.

* If a pod’s readiness probe fails, the pod is removed from the Endpoints
  object.

### Adding a readiness probe to a pod

* add readiness probe            kubia-rc-readinessprobe.yaml
                                 apiVersion: v1
                                 kind: ReplicationController
                                 metadata:
                                   name: kubia
                                 spec:
                                   replicas: 3
                                   selector:
                                     app: kubia
                                   template:
                                     metadata:
                                       labels:
                                         app: kubia
                                     spec:
                                       containers:
                                       - name: kubia
                                         image: luksa/kubia
                                         ports:
                                         - name: http
                                           containerPort: 8080
                                         readinessProbe:
                                           exec:
                                             command:
                                             - ls
                                             - /var/ready

* restart the pods               $ kubectl delete pods --all

* list pods                      $ kubectl get po

* set probe to pass              $ kubectl exec <pod name> -- touch /var/ready
                                 Note: Takes up to 10 seconds for probe to occur.

* view describe                  $ kubectl describe
                                 Readiness: exec [ls /var/ready] delay=0s timeout=1s period=10s #success=1 #failure=3

* check endpoint                 $ kubectl get endpoints kubia-loadbalancer

* check curl                     $ curl http://130.211.53.173

* Manually removing pods from services should be performed by either deleting
  the pod or changing the pod’s labels instead of manually flipping a switch in
  the probe.

* If you want to add or remove a pod from a service manually, add enabled=true
  as a label to your pod and to the label selector of your service. Remove the
  label when you want to remove the pod from the service.

* Always define a readiness probe. Otherwise, may see “Connection refused” 
  types of errors.

* Do not include pod shutdown logic into your readiness probes

## 5.6 Using a headless service for discovering individual pods

* For a client to connect to all pods, it needs to figure out the the IP of
  each individual pod.

* Should always strive to keep your apps Kubernetes-agnostic.

* spec.clusterIP = None

  Instead of returning a single DNS A record, the DNS server will 
  return multiple A records for the service, each pointing to the IP of
  an individual pod backing the service at that moment.

* headless server yaml           apiVersion: v1
                                 kind: Service
                                 metadata:
                                   name: kubia-headless
                                 spec:
                                   clusterIP: None       // This makes the service headless.
                                   ports:
                                   - port: 80
                                     targetPort: 8080
                                   selector:
                                     app: kubia

### Discovering pods through DNS

* tutum/dnsutils container contains both the nslookup and the dig binaries.


* running pod w/o yaml           $ kubectl run dnsutils --image=tutum/dnsutils --generator=run-pod/v1 --command -- sleep infinity

* perform a DNS lookup           $ kubectl exec dnsutils nslookup kubia-headless
                                 ...
                                 Name: kubia-headless.default.svc.cluster.local
                                 Address: 10.108.1.4
                                 Name: kubia-headless.default.svc.cluster.local
                                 Address: 10.108.2.5

* to verify                      $ kubectl get pods -o wide

* no headless                    $ kubectl exec dnsutils nslookup kubia
                                 ...
                                 Name: kubia.default.svc.cluster.local
                                 Address: 10.111.249.153

* A headless services still provides load balancing across pods, but through
  the DNS round-robin mechanism instead of through the service proxy.

### Discovering all pods—even those that aren’t ready

* Can use the DNS lookup mechanism to find even those unready pods.

* tell k8s you want all pods     kind: Service
                                   metadata:
                                     annotations:
                                       service.alpha.kubernetes.io/tolerate-unready-endpoints: "true"

* or                             spec.publishNotReadyAddresses=true
                                 Note: In k8s version 1.9.0

## 5.7 Troubleshooting services

* First, make sure you’re connecting to the service’s cluster IP from within the
  cluster, not from the outside.

* Don’t bother pinging the service IP to figure out if the service is accessible
  (remember, the service’s cluster IP is a virtual IP and pinging it will never
  work).

* If you’ve defined a readiness probe, make sure it’s succeeding; otherwise the
  pod won’t be part of the service.

* To confirm that a pod is part of the service, examine the corresponding 
  Endpoints object with kubectl get endpoints.

* If you’re trying to access the service through its FQDN or a part of it (for
  example, myservice.mynamespace.svc.cluster.local or myservice.mynamespace) and
  it doesn’t work, see if you can access it using its cluster IP instead of the
  FQDN.

* Check whether you’re connecting to the port exposed by the service and not
  the target port.

* Try connecting to the pod IP directly to confirm your pod is accepting
  connections on the correct port.

* If you can’t even access your app through the pod’s IP, make sure your app
  isn’t only binding to localhost.

# Chapter 6: Volumes: attaching disk storage to containers

## 6.1 Introducing volumes

* Container's storage is deleted when a container dies.

* Pod's storage volumes (external disk storage and/or share storage) persists
  beyond death of container.

* A volume is bound to the life cycle of a pod and will stay in existence only
  while the pod exists, but depending on the volume type, the volume’s files ma
  remain intact even after the pod and volume disappear, and can later be
  mounted into a new volume.

* k8s volumes are a component of a pod and are thus defined in the pod’s spec.

* Volumes aren’t a standalone k8s object and cannot be created or deleted on
  their own.

* A volume is available to all containers in the pod.

* Volume must be mounted in each container that needs to access it.

* Linux allows you to mount a filesystem at arbitrary locations in the file tree.

* A single pod can use multiple volumes of different types at the same time,

### Volume types

* emptyDir: A simple empty directory used for storing transient data.

* hostPath: Used for mounting directories from the worker node’s filesystem
  into the pod.

* gitRepo: A volume initialized by checking out the contents of a Git repository.

* nfs: An NFS share mounted into the pod.

* cloud provider specific storage
  * gcePersistentDisk: Google Compute Engine Persistent Disk
  * awsElasticBlockStore: Amazon Web Services Elastic Block Store Volume
  * azureDisk: Microsoft Azure Disk Volume

* other types of network storage
  cinder, cephfs, iscsi, flocker, glusterfs, quobyte, rbd, flexVolume, 
  vsphereVolume, photonPersistentDisk, scaleIO

* configMap, secret, downwardAPI—

* Special types of volumes used to expose certain Kubernetes resources and
  cluster information to the pod:
  * configMap
  * secret
  * downwardAPI

* persistentVolumeClaim: A way to use a pre- or dynamically provisioned
  persistent storage.


## 6.2 Using volumes to share data between containers

### emptyDir volume

* not persistent storage: When the pod is deleted, the volume and its contents
  are deleted.

* The volume starts out as an empty directory.

* The app running inside the pod can then write any files it needs to it.

* Useful:
  * For sharing files between containers running in the same pod.
  * By a single container for when a container needs to write data to
    disk temporarily, such as when performing a sort operation on a
    large dataset.

* Building the fortune container image
  See page 164.

* fortune-pod.yaml               apiVersion: v1
                                 kind: Pod
                                 metadata:
                                   name: fortune
                                 spec:
                                   containers:
                                   - image: luksa/fortune
                                     name: html-generator
                                     volumeMounts:
                                     - name: html
                                       mountPath: /var/htdocs
                                   - image: nginx:alpine
                                     name: web-server
                                     volumeMounts:
                                     - name: html
                                       mountPath: /usr/share/nginx/html
                                       readOnly: true
                                     ports:
                                     - containerPort: 80
                                       protocol: TCP
                                   volumes:
                                   - name: html
                                     emptyDir: {}

* forward address                $ kubectl port-forward fortune 8080:80
                                 Forwarding from 127.0.0.1:8080 -> 80
                                 Forwarding from [::1]:8080 -> 80

* access server                  $ curl http://localhost:8080
                                 Beware of a tall blond man with one black shoe.

* create the emptyDir on a      volumes:
  tmpfs filesystem (in memory     - name: html
  instead of on disk).              emptyDir:
                                      medium: Memory

### gitRepo volume

* not persistent storage: When the pod is deleted, the volume and its contents
  are deleted.

* A gitRepo volume is basically an emptyDir volume that gets populated by 
  cloning a Git repository and checking out a specific revision when the pod is
  starting up (but before its containers are created).

* The gitRepo volume isn’t kept in sync with the Git repository.

* To see the new version of the website, you need to delete the pod and create
  it again.

* github repo                    https://github.com/luksa/kubia-website-example.git

* gitrepo-volume-pod.yaml        apiVersion: v1
                                 kind: Pod
                                 metadata:
                                   name: gitrepo-volume-pod
                                 spec:
                                   containers:
                                   - image: nginx:alpine
                                     name: web-server
                                     volumeMounts:
                                     - name: html
                                       mountPath: /usr/share/nginx/html
                                       readOnly: true
                                     ports:
                                     - containerPort: 80
                                       protocol: TCP
                                   volumes:
                                   - name: html
                                     gitRepo:
                                       repository: https://github.com/luksa/kubia-website-example.git
                                       revision: master
                                       directory: .

* sidecar container

  * A sidecar container is a container that augments the operation of the main
    container of the pod.

  * You add a sidecar to a pod so you can use an existing container image
    instead of cramming additional logic into the main app’s code, which would
    make it overly complex and less reusable.

  * Chapter 18 includes using a Git sync sidecar container.

  * Can not use a gitRepo volume with a private Git repo. Will need to 
    use a gitsync sidecar or a similar method instead of a gitRepo volume.

## 6.3 Accessing files on the worker node’s filesystem

### hostPath volume

* semi-persistent storage: The contents of volume can survive multiple pod
  instantiations. (Requires the developer of the pod to have knowledge of the
  actual network storage infrastructure.)

* hostPath volumes are often used for trying out persistent storage
  in single-node clusters. Not appropriate for multi-node clusters.

* A hostPath volume points to a specific file or directory on the node’s 
  filesystem.

* Pods running on the same node and using the same path in their hostPath
  volume see the same files.

* If a pod is deleted and the next pod uses a hostPath volume pointing
  to the same path on the host, the new pod will see whatever was left
  behind by the previous pod, but only if it’s scheduled to the same
  node as the first pod.

* It’s not a good idea to use a hostPath volume for regular pods, because it
  makes the pod sensitive to what node it’s scheduled to.

* Remember to use hostPath volumes only if you need to read or write system
  files on the node. Never use them to persist data across pods.

* display vol types              $ kubectl describe po --namespace kube-system
                                 Name:                 coredns-6dcc67dcbc-5qjkc
                                 Namespace:            kube-system
                                 ...
                                 Volumes:
                                   tmp:
                                     Type:       EmptyDir (a temporary directory that shares a pod's lifetime)
                                     Medium:
                                     SizeLimit:  <unset>
                                   config-volume:
                                     Type:      ConfigMap (a volume populated by a ConfigMap)
                                     Name:      coredns
                                     Optional:  false
                                   coredns-token-bfbjb:
                                     Type:        Secret (a volume populated by a Secret)
                                     SecretName:  coredns-token-bfbjb
                                     Optional:    false

                                     Name:                 kube-apiserver-docker-desktop
                                     Namespace:            kube-system
                                     ...
                                     Volumes:
                                       ca-certs:
                                         Type:          HostPath (bare host directory volume)
                                         Path:          /etc/ssl/certs
                                         HostPathType:  DirectoryOrCreate
                                       etc-ca-certificates:
                                         Type:          HostPath (bare host directory volume)
                                         Path:          /etc/ca-certificates
                                         HostPathType:  DirectoryOrCreate
                                       k8s-certs:
                                         Type:          HostPath (bare host directory volume)
                                         Path:          /run/config/pki
                                         HostPathType:  DirectoryOrCreate
                                       usr-local-share-ca-certificates:
                                         Type:          HostPath (bare host directory volume)
                                         Path:          /usr/local/share/ca-certificates
                                         HostPathType:  DirectoryOrCreate
                                       usr-share-ca-certificates:
                                         Type:          HostPath (bare host directory volume)
                                         Path:          /usr/share/ca-certificates
                                         HostPathType:  DirectoryOrCreate

## 6.4 Using persistent storage

* persistent storage: Same data available even when the pod is rescheduled to
  another node. Because this data needs to be accessible from any cluster node,
  it must be stored on some type of network-attached storage (NAS).

* mongodb-pod-gcepd.yaml         apiVersion: v1
                                 kind: Pod
                                 metadata:
                                   name: mongodb 
                                 spec:
                                   volumes:
                                   - name: mongodb-data
                                     gcePersistentDisk:
                                       pdName: mongodb
                                       fsType: ext4
                                   containers:
                                   - image: mongo
                                     name: mongodb
                                     volumeMounts:
                                     - name: mongodb-data
                                       mountPath: /data/db
                                     ports:
                                     - containerPort: 27017
                                       protocol: TCP

## 6.5 Decoupling pods from the underlying storage technology

* Developer does not need to have knowledge of the actual network
  storage infrastructure.

* Cluster administrator sets up the underlying storage and then registers it in
  Kubernetes by creating a PersistentVolume resource.

* PersistentVolumeClaim: specifies minimum size and access mode required

### PersistentVolumes and PersistentVolumeClaims resources

* Nodes                    don’t belong to any namespace
* Pods                     do belong to a namespace

* StorageClass             don’t belong to any namespace
* PersistentVolumes        don’t belong to any namespace
* PersistentVolumeClaims   do belong to a namespace

* mongodb-pv-hostpath.yaml       apiVersion: v1
                                 kind: PersistentVolume
                                 metadata:
                                   name: mongodb-pv
                                 spec:
                                   capacity: 
                                     storage: 1Gi
                                   accessModes:
                                     - ReadWriteOnce
                                     - ReadOnlyMany
                                   persistentVolumeReclaimPolicy: Retain
                                   hostPath:
                                     path: /tmp/mongodb

* list PersistentVolumes         $ kubectl get pv
  (Available)                    NAME        CAPACITY  RECLAIMPOLICY  ACCESSMODES   STATUS     CLAIM
                                 mongodb-pv  1Gi       Retain         RWO,ROX       Available
                                 (Books)

                                 NAME                                       CAPACITY   ACCESS MODES   RECLAIM POLICY   STATUS   CLAIM                               STORAGECLASS   REASON   AGE
                                 pvc-d4117667-00f2-11ea-9dda-025000000001   100Gi      RWO            Delete           Bound    kafka/data-my-cluster-zookeeper-0   hostpath                132d
                                 pvc-f8cdd266-00f2-11ea-9dda-025000000001   100Gi      RWO            Delete           Bound    kafka/data-0-my-cluster-kafka-0     hostpath                132d
                                 (my installation)

### Creating a persistent volume claim

* Claiming a PersistentVolume is a completely separate process from creating
  a pod, because you want the same PersistentVolumeClaim to stay available even
  if the pod is rescheduled.

* mongodb-pvc.yaml               $ apiVersion: v1
                                 kind: PersistentVolumeClaim
                                 metadata:
                                   name: mongodb-pvc 
                                 spec:
                                   resources:
                                     requests:
                                       storage: 1Gi
                                   accessModes:
                                   - ReadWriteOnce
                                   storageClassName: ""

* list PersistentVolumeClaims    $ kubectl get pvc
                                 NAME         STATUS  VOLUME      CAPACITY  ACCESSMODES  AGE
                                 mongodb-pvc  Bound   mongodb-pv  1Gi       RWO,ROX      3s

* Abbreviations used for the access modes
  RWO  ReadWriteOnce  Only a single node can mount the volume for reading and writing.
  ROX  ReadOnlyMany   Multiple nodes can mount the volume for reading.
  RWX  ReadWriteMany  Multiple nodes can mount the volume for both reading and writing.

* RWO, ROX, and RWX pertain to the number of worker nodes that can use the
  volume at the same time, not to the number of pods!

* list PersistentVolumes         $ kubectl get pv
  (Bound)                        NAME        CAPACITY  ACCESSMODES  STATUS  CLAIM                AGE
                                 mongodb-pv  1Gi       RWO,ROX      Bound   default/mongodb-pvc  1m

### Using a PersistentVolumeClaim in a pod

* mongodb-pod-pvc.yaml           $ apiVersion: v1
                                 kind: Pod
                                 metadata:
                                   name: mongodb 
                                 spec:
                                   containers:
                                   - image: mongo
                                     name: mongodb
                                     volumeMounts:
                                     - name: mongodb-data
                                       mountPath: /data/db
                                     ports:
                                     - containerPort: 27017
                                       protocol: TCP
                                   volumes:
                                   - name: mongodb-data
                                     persistentVolumeClaim:
                                       claimName: mongodb-pvc

* verify  db entry               $ kubectl exec -it mongodb mongo
                                 MongoDB shell version: 3.2.8
                                 connecting to: mongodb://127.0.0.1:27017
                                 Welcome to the MongoDB shell.
                                 ...
                                 > use mystore
                                 switched to db mystore
                                 > db.foo.find()
                                 { "id" : ObjectId("57a61eb9de0cfd512374cc75"), "name" : "foo" }


### Understanding the benefits of using PersistentVolumes and claims

* Require the additional steps of creating the PersistentVolume and the 
  PersistentVolumeClaim, but the developer doesn’t have to know anything about
  the actual storage technology used underneath.

* The same pod and claim manifests can now be used on many different
  Kubernetes clusters, because they don’t refer to anything 
  infrastructure-specific.

### Recycling PersistentVolumes

* persistentVolumeReclaimPolicy: 
  Retain    Retain the volume and its contents after it’s released from its claim.
  Recycle   Deletes the volume’s contents and makes the volume available to be claimed again.
  Delete    Deletes the underlying storage.

## 6.6 Dynamic provisioning of PersistentVolumes

### Defining the available storage types through StorageClass resources

* storageclass-fast-gcepd.yaml   apiVersion: v1
                                 kind: PersistentVolume
                                 metadata:
                                   name: mongodb-pv
                                 spec:
                                   capacity: 
                                     storage: 1Gi
                                   accessModes:
                                     - ReadWriteOnce
                                     - ReadOnlyMany
                                   persistentVolumeReclaimPolicy: Retain
                                   hostPath:
                                     path: /tmp/mongodb


### Requesting the storage class in a PersistentVolumeClaim

* mongodb-pvc-dp.yaml            $ apiVersion: v1
                                 kind: PersistentVolumeClaim
                                 metadata:
                                   name: mongodb-pvc 
                                 spec:
                                   storageClassName: fast
                                   resources:
                                     requests:
                                       storage: 100Mi
                                   accessModes:
                                     - ReadWriteOnce

### Dynamic provisioning without specifying a storage class

* list storage class             $ kubectl get sc
                                 NAME                 TYPE
                                 fast                 kubernetes.io/gce-pd
                                 standard (default)   kubernetes.io/gce-pd
                                 (book)

                                 NAME                 PROVISIONER          AGE
                                 hostpath (default)   docker.io/hostpath   138d
                                 (my installation)

* To summarize, the best way to attach persistent storage to a pod is to only
  create the PVC (with an explicitly specified storageClassName if necessary)
  and the pod (which refers to the PVC by name). Everything else is taken care
  of by the dynamic PersistentVolume provisioner.

# Chapter 7: ConfigMaps and Secrets: configuring applications

## 7.1 Configuring containerized application

* Usually configuration of containerized applications
  - Can bake the configuration into the application
  - App configured through command-line arguments
  - Configuration into a config file.
  - Environment variables
  - Using configuration files inside Docker container
  - Mount a volume containing the file into the container.
  - Using a gitRepo volume as a configuration source.
  - ConfigMap, a top-level Kubernetes resource, is k8s preferred way.

* ConfigMap: The Kubernetes resource for storing configuration data 

## 7.2 Passing command-line arguments to containers

### Defining the command and arguments in Docker

* In a Dockerfile, two instructions define the two parts:
  * ENTRYPOINT defines the executable invoked when the container is started.
  * CMD specifies the arguments that get passed to the ENTRYPOINT.

* cmd only                      $ docker run <image>

* cnd & args                    $ docker run <image> <arguments>

### Difference between the shell and exec forms

* The difference is whether the specified command is invoked inside a shell or not.

* exec form: ENTRYPOINT ["node", "app.js"]
  $ docker exec 4675d ps x
  PID TTY   STAT   TIME   COMMAND
  1   ?     Ssl    0:00   node app.js
  12  ?     Rs     0:00   ps x

* shell form: ENTRYPOINT node app.js
  $ docker exec -it e4bad ps x
  PID  TTY   STAT  TIME  COMMAND
  1    ?     Ss    0:00  /bin/sh -c node app.js
  7    ?     Sl    0:00  node app.js
  13   ?     Rs+   0:00  ps x

* The shell process is unnecessary, which is why you should always use the 
  exec form of the ENTRYPOINT instruction.

### Example: MAKING THE INTERVAL CONFIGURABLE IN YOUR FORTUNE IMAGE
 
* fortuneloop.sh                #!/bin/bash
                                trap "exit" SIGINT
                                INTERVAL=$1
                                echo Configured to generate new fortune every $INTERVAL seconds
                                mkdir -p /var/htdocs
                                while :
                                do
                                  echo $(date) Writing fortune to /var/htdocs/index.html
                                  /usr/games/fortune > /var/htdocs/index.html
                                  sleep $INTERVAL
                                done

* Dockerfile file               FROM ubuntu:latest
                                RUN apt-get update ; apt-get -y install fortune
                                ADD fortuneloop.sh /bin/fortuneloop.sh
                                ENTRYPOINT ["/bin/fortuneloop.sh"]
                                CMD ["10"]

* docker login                  $ docker login

* build a docker image          $ docker build -t fortune:args .       // syntax: docker build -t <app-name:tag> <dir-loc>

* run latest image              $ docker run -it fortune:args          // syntax docker run <image>
                                Configured to generate new fortune every 10 seconds
                                Wed Mar 18 23:24:06 UTC 2020 Writing fortune to /var/htdocs/index.html
                                Wed Mar 18 23:24:16 UTC 2020 Writing fortune to /var/htdocs/index.html
                                ...

* list running containers       $ docker ps
                                CONTAINER ID        IMAGE                               COMMAND                  CREATED             STATUS              PORTS               NAMES
                                e21d999a8f4f        fortune:args                        "/bin/fortuneloop.sh…"   11 seconds ago      Up 9 seconds                            modest_vaughan

* stop container                $ docker stop modest_vaughan           // docker stop <name>
                                or
                                Control+C

* override the default          $ docker run -it fortune:args 15
  sleep interval                Configured to generate new fortune every 15 seconds
                                Wed Mar 18 23:57:49 UTC 2020 Writing fortune to /var/htdocs/index.html
                                Wed Mar 18 23:58:04 UTC 2020 Writing fortune to /var/htdocs/index.html
                                ...

### Overriding the command and arguments in Kubernetes

* Specifying the executable and its arguments in Docker vs Kubernetes

  Docker         Kubernetes     Description
  ENTRYPOINT     command        The executable that’s executed inside the container
  CMD            args           The arguments passed to the executable

* A pod definition specifying   kind: Pod
  a custom command and          spec:
  arguments                       containers:
                                  - image: some/image
                                    command: ["/bin/command"]
                                    args: ["arg1", "arg2", "arg3"]

* Usually, you set arguments and rarely override the command. (except in 
  general purpose images such as busybox, which doesn’t define an
  ENTRYPOINT at all).

* fortune-pod-args.yaml         apiVersion: v1
                                kind: Pod
                                metadata:
                                  name: fortune2s
                                spec:
                                  containers:
                                  - image: fortune:args
                                    args: ["2"]
                                    name: html-generator
                                    volumeMounts:
                                    - name: html
                                      mountPath: /var/htdocs
                                  - image: nginx:alpine
                                    name: web-server
                                    volumeMounts:
                                    - name: html
                                      mountPath: /usr/share/nginx/html
                                      readOnly: true
                                    ports:
                                    - containerPort: 80
                                      protocol: TCP
                                  volumes:
                                  - name: html
                                    emptyDir: {}

* create pod                     $ kubectl create -f fortune-pod-args.yaml
                                 pod/fortune2s created

* view log                       $ kubectl logs -f fortune2s html-generator
                                 Configured to generate new fortune every 2 seconds
                                 Thu Mar 19 19:09:37 UTC 2020 Writing fortune to /var/htdocs/index.html
                                 Thu Mar 19 19:09:39 UTC 2020 Writing fortune to /var/htdocs/index.html
                                 Thu Mar 19 19:09:41 UTC 2020 Writing fortune to /var/htdocs/index.html
                                 ...

* delete pod                     $ kubectl delete pod fortune2s
                                 pod "fortune2s" deleted

## 7.3 Setting environment variables for a container

* Containerized applications often use environment variables.

* k8s allows custom list of environment variables for each container of a pod.

* Environment variable are set inside the container definition, not at the pod level.

* Kubernetes automatically exposes environment variables for each service in the
  same namespace. These environment variables are basically auto-injected 
  configuration.

* The list of environment variables also cannot be updated after the pod is created.

* How to access env var in language
  - bash       $INTERVAL
  - Java       System.getenv("INTERVAL")
  - Node.JS    process.env.INTERVAL
  - Python     os.environ['INTERVAL']

### Specifying environment variables in a container definition

[LEARN]

* fortune-env/fortuneloop.sh     $ #!/bin/bash
                                 trap "exit" SIGINT
                                 echo Configured to generate new fortune every $INTERVAL seconds
                                 mkdir -p /var/htdocs
                                 while :
                                 do
                                   echo $(date) Writing fortune to /var/htdocs/index.html
                                   /usr/games/fortune > /var/htdocs/index.html
                                   sleep $INTERVAL
                                 done

* Docker                        FROM ubuntu:latest
                                RUN apt-get update ; apt-get -y install fortune
                                ADD fortuneloop.sh /bin/fortuneloop.sh
                                ENTRYPOINT ["/bin/fortuneloop.sh"]

* docker login                  $ docker login

* build a docker image          $ docker build -t fortune:env .

* fortune-pod-env.yaml          apiVersion: v1
                                kind: Pod
                                metadata:
                                  name: fortune-env
                                spec:
                                  containers:
                                  - image: fortune:env
                                    env:
                                    - name: INTERVAL
                                      value: "30"
                                    name: html-generator
                                    volumeMounts:
                                    - name: html
                                      mountPath: /var/htdocs
                                  - image: nginx:alpine
                                    name: web-server
                                    volumeMounts:
                                    - name: html
                                      mountPath: /usr/share/nginx/html
                                      readOnly: true
                                    ports:
                                    - containerPort: 80
                                      protocol: TCP
                                  volumes:
                                  - name: html
                                    emptyDir: {}

* create pod                     $ kubectl create -f fortune-pod-env.yaml
                                 pod/fortune-env created

* view log                       $ kubectl logs -f fortune-env html-generator
                                 Configured to generate new fortune every 30 seconds
                                 Thu Mar 19 23:19:40 UTC 2020 Writing fortune to /var/htdocs/index.html
                                 Thu Mar 19 23:20:10 UTC 2020 Writing fortune to /var/htdocs/index.html
                                 ...

### Referring to an environment variable inside another one

* Referring to an environment    env:
  variable inside another one    - name: FIRST_VAR
                                   value: "foo"
                                 - name: SECOND_VAR
                                   value: "$(FIRST_VAR)bar"

### Understanding the drawback of hard coding environment variables

* Need to have separate pod definitions for your production and your development pods.

* Can decouple using ConfigMap resources using "valueFrom" instead of
  the "value" field.

## 7.4 Decoupling configuration with a ConfigMap

### Overview of ConfigMap

[LEARN]

Description                   Command Line or File             ConfigMap                  Pod 
----------------------------  -------------------------------  -------------------------  -----------------------------
Create at cmd line            --from-literal=ln=lv             data                       pod.spec.containers.env.valueFrom.configMapKeyRef

Create from a file,           --from-file=fn                   data                       pod.spec.containers.env.valueFrom.configMapKeyRef
default key name

Create from a file,           --from-file=ckn=fn               data                       pod.spec.containers.env.valueFrom.configMapKeyRef
custom key name

Create from files             --from-file=dn                   data                       pod.spec.containers.env.valueFrom.configMapKeyRef
in directory

Passing a ConfigMap entry     NA                               data                       pod.spec.containers.env.valueFrom.configMapKeyRef
to a container as an env var 

Passing all entries of a      NA                               data                       pod.spec.containers.envFrom.configMapRef
ConfigMap as environment 
variables at once

Passing a ConfigMap entry     NA                               data                       pod.spec.containers.env.valueFrom.configMapKeyRef
as a command-line argument                                                                pod.spec.containers.args.["$(INTERVAL)"]

Using a configMap volume      conf file "a.conf                data.a.conf:               - image: nginx:alpine
to expose ConfigMap           single value file "b"            data.b:                       volumeMounts:
entries as files              single value file "c"            data.c:                       - name: config
                                                               (as fortune-config)             mountPath: /etc/nginx/conf.d
                                                                                               readOnly: true
                                                                                           volumes:
                                                                                           - name: config
                                                                                             configMap:
                                                                                               name: fortune-config

* valueFrom (property)
  * pod.spec.containers.env.valueFrom
  * Source for the environment variable's value.
  * configMapKeyRef       Selects a key of a ConfigMap
  * fieldRef              Selects a field of the pod
  * resourceFieldRef      Selects a resource of the container
  * secretKeyRef          Selects a key of a secret in the pod's namespace

* envFrom (property)
  * pod.spec.containers.envFrom
  * List of sources to populate environment variables in the container.
  * configMapRef         The ConfigMap to select from
  * prefix <string>      An optional identifier to prepend to each key in the
                         ConfigMap. Must be a C_IDENTIFIER.
  * secretRef <Object>   The Secret to select from

----------------------------  -------------------------------  -------------------------  ----------------------------

$ kubectl explain pod.spec.containers.env.valueFrom

KIND:     Pod
VERSION:  v1

RESOURCE: valueFrom <Object>

DESCRIPTION:
     Source for the environment variable's value. Cannot be used if value is not
     empty.

     EnvVarSource represents a source for the value of an EnvVar.

FIELDS:
   configMapKeyRef  <Object>
     Selects a key of a ConfigMap.

   fieldRef <Object>
     Selects a field of the pod: supports metadata.name, metadata.namespace,
     metadata.labels, metadata.annotations, spec.nodeName,
     spec.serviceAccountName, status.hostIP, status.podIP.

   resourceFieldRef <Object>
     Selects a resource of the container: only resources limits and requests
     (limits.cpu, limits.memory, limits.ephemeral-storage, requests.cpu,
     requests.memory and requests.ephemeral-storage) are currently supported.

   secretKeyRef <Object>
     Selects a key of a secret in the pod's namespace

----------------------------  -------------------------------  -------------------------  ----------------------------

* Goal of an app’s configuration: keep the config options that vary between
  environments, or change frequently, separate from the application’s source
  code.

* ConfigMap: a k8s object that contains configuration information
  * key/value pairs
  * short literals to full config files
  * passed to containers as either environment variables or as files in a volume
  * ConfigMap entries passed to processes as command-line arguments
  * App can read the contents of a ConfigMap directly through the k8s REST API
    endpoint. But don't do that!
  * Facilitates keeping multiple manifests for ConfigMaps with the same name, 
    each for a different environment (development, testing, QA, production,
    and so on).
  * Because pods reference the ConfigMap by name, you can use a different
    config in each environment while using the same pod specification across
    all of them.
  * ConfigMap keys must be a valid DNS subdomain (they may only contain
    alphanumeric characters, dashes, underscores, and dots). They may
    optionally include a leading dot.



### --from-literal=ln=lv...Create at cmd line

Single Entry

* configMap cmd line             $ kubectl create configmap fortune-config --from-literal=sleep-interval=25
                                 configmap/fortune-config created

* YAML descriptor                $ kubectl get configmap fortune-config  -o yaml
                                 apiVersion: v1
                                 data:
                                   sleep-interval: "25"
                                 kind: ConfigMap
                                 metadata:
                                   creationTimestamp: "2020-03-20T19:06:03Z"
                                   name: fortune-config
                                   namespace: default
                                   resourceVersion: "7185982"
                                   selfLink: /api/v1/namespaces/default/configmaps/fortune-config
                                   uid: d7fe79cb-6add-11ea-99d1-025000000001

Multiple Entry

* Can add multiple values by using the --from-literal argument multiple times.

* multiple literal entries       $ kubectl create configmap myconfigmap --from-literal=foo=bar --from-literal=bar=baz --from-literal=one=two
                                 configmap/myconfigmap created

* configMap cmd line             $ kubectl get configmap/myconfigmap  -o yaml

* YAML descriptor                apiVersion: v1
                                 data:
                                   bar: baz
                                   foo: bar
                                   one: two
                                 kind: ConfigMap
                                 metadata:
                                   creationTimestamp: "2020-03-20T19:13:12Z"
                                   name: myconfigmap
                                   namespace: default
                                   resourceVersion: "7186544"
                                   selfLink: /api/v1/namespaces/default/configmaps/myconfigmap
                                   uid: d7c1ef53-6ade-11ea-99d1-025000000001

### --from-file=fn.........Create from a file, default key name

* default, filename used as key   $ kubectl create configmap my-config --from-file=config-file.conf
  "config-file.conf"

### --from-file=ckn=fn.....Create from a file, custom key name

* custom key,                     $ kubectl create configmap my-config --from-file=customkey=config-file.conf
  "customkey"

### --from-file=dn.........Create from files in a directory

* Will create an individual map entry for each file in the specified directory.
* But only for files whose name is a valid ConfigMap key.

* create from files in dir       $ kubectl create configmap my-config --from-file=/path/to/dir

### .......................Combine different options

* varied options                 $ kubectl create configmap my-config
                                   --from-file=foo.json                     // A single file
                                   --from-file=bar=foobar.conf              // A file stored under a custom key
                                   --from-file=config-opts/                 // A whole directory
                                   --from-literal=some=thing                // A literal value

### env.name.valueFrom.....Passing a ConfigMap entry to a container as an environment variable

[LEARN]

* fortune-config.yaml            apiVersion: v1
                                 kind: ConfigMap
                                 metadata:
                                   name: fortune-config
                                 data:
                                   sleep-interval: "25"

* fortune-pod-env-configmap.yaml  apiVersion: v1
                                  kind: Pod
                                  metadata:
                                    name: fortune-env-from-configmap
                                  spec:
                                    containers:
                                    - image: luksa/fortune:env
                                      env:
                                      - name: INTERVAL                  // Setting the environment variable called INTERVAL
                                        valueFrom: 
                                          configMapKeyRef:              // Initializing from a ConfigMap key.
                                            name: fortune-config        // Name of the ConfigMap
                                            key: sleep-interval         // setting the variable to whatever is stored under this key in the ConfigMap.
                                      name: html-generator
                                      volumeMounts:
                                      - name: html
                                        mountPath: /var/htdocs
                                    - image: nginx:alpine
                                      name: web-server
                                      volumeMounts:
                                      - name: html
                                        mountPath: /usr/share/nginx/html
                                        readOnly: true
                                      ports:
                                      - containerPort: 80
                                        protocol: TCP
                                    volumes:
                                    - name: html
                                      emptyDir: {}

* configMap uses    configMapKeyRef property
* secret uses       secretKeyRef property

### .......................Referencing non-existing ConfigMaps in a pod

* Pod will not create if configMap is not already created.
* When configMap is created, will will resume creation.
* ConfigMap can be made optional using: configMapKeyRef.optional: true

### envFrom................Passing all entries of a ConfigMap as environment variables at once

* Can expose all entries of a ConfigMap as env vars using "envFrom" attribute

*                                spec:
                                   containers:
                                   - image: some-image
                                     envFrom:                           // Using envFrom instead of env
                                     - prefix: CONFIG_                  // All environment variables will be prefixed with CONFIG_.
                                       configMapRef:                    // Referencing the ConfigMap called my-config-map
                                         name: my-config-map

* Valid environment variable name for ConfigMap key
  * Cannot contain a dash
  * If a ConfigMap key isn’t in the proper format, it skips the entry (but it
    does record an event informing you it skipped it).

### valueFrom..............Passing a ConfigMap entry as a command-line argument

* Can’t reference ConfigMap entries directly in the pod.spec.containers.args field

* But you can first initialize an environment variable from the ConfigMap entry
  and then refer to the variable inside the arguments.

* Defined the environment variable exactly as you did before (env.name.valueFrom), 
  but then you used the $(ENV_VARIABLE_NAME) syntax to have Kubernetes inject
  the value of the variable into the argument.

* fortune-pod-args-configmap.yaml
                                apiVersion: v1
                                kind: Pod
                                metadata:
                                  name: fortune-args-from-configmap
                                spec:
                                  containers:
                                  - image: luksa/fortune:args
                                    env:
                                    - name: INTERVAL
                                      valueFrom: 
                                        configMapKeyRef:
                                          name: fortune-config
                                          key: sleep-interval
                                    args: ["$(INTERVAL)"]


### Using a configMap volume to expose ConfigMap entries as files

* configMap volume
  * Ideal for passing large config files
  * But can also pass individual value


* my-nginx-config.conf           server {
                                     listen              80;
                                     server_name         www.kubia-example.com;
                                 
                                     gzip on;
                                     gzip_types text/plain application/xml;
                                 
                                     location / {
                                         root   /usr/share/nginx/html;
                                         index  index.html index.htm;
                                     }
                                 
                                 }

* sleep-interval                 $ cat sleep-interval
                                 25

* work-hours-per-week            $ cat sleep-interval
                                 80


* create configMap               $ kubectl create configmap fortune-config --from-file=configmap-files/
                                 configmap/fortune-config created

* show yaml                      $ kubectl get configmap/fortune-config -o yaml
                                 apiVersion: v1
                                 data:
                                   my-nginx-config.conf: |
                                     server {
                                         listen              80;
                                         server_name         www.kubia-example.com;
                                 
                                         gzip on;
                                         gzip_types text/plain application/xml;
                                 
                                         location / {
                                             root   /usr/share/nginx/html;
                                             index  index.html index.htm;
                                         }
                                 
                                     }
                                   sleep-interval: |
                                     25
                                   work-hours-per-week: |
                                     80
                                 kind: ConfigMap
                                 ...

* NOTE The pipeline character after the colon in the first line of both entries
  signals that a literal multi-line value follows.

### Using the configMap's entries in a volume

* fortune-pod-configmapvolume.yaml
                                 apiVersion: v1
                                 kind: Pod
                                 metadata:
                                   name: fortune-configmap-volume
                                 spec:
                                   containers:
                                   - image: luksa/fortune:env
                                     env:
                                     - name: INTERVAL
                                       valueFrom:
                                         configMapKeyRef:
                                           name: fortune-config
                                           key: sleep-interval
                                     name: html-generator
                                     volumeMounts:
                                     - name: html
                                       mountPath: /var/htdocs
                                   - image: nginx:alpine
                                     name: web-server
                                     volumeMounts:
                                     - name: html
                                       mountPath: /usr/share/nginx/html
                                       readOnly: true
                                     - name: config
                                       mountPath: /etc/nginx/conf.d
                                       readOnly: true
                                     - name: config
                                       mountPath: /tmp/whole-fortune-config-volume
                                       readOnly: true
                                     ports:
                                       - containerPort: 80
                                         name: http
                                         protocol: TCP
                                   volumes:
                                   - name: html
                                     emptyDir: {}
                                   - name: config
                                     configMap:
                                       name: fortune-config

* create pod                     $ kubectl create -f fortune-pod-configmap-volume.yaml
                                 pod/fortune-configmap-volume created

### Verify nginx is using the mounted config file

* forward port                   $ kubectl port-forward fortune-configmap-volume 8080:80 &
                                 Forwarding from 127.0.0.1:8080 -> 80
                                 Forwarding from [::1]:8080 -> 80

* confirm zip  working           $ curl -H "Accept-Encoding: gzip" -I localhost:8080
                                 HTTP/1.1 200 OK
                                 Server: nginx/1.17.9
                                 Date: Sun, 22 Mar 2020 19:28:10 GMT
                                 Content-Type: text/html
                                 Last-Modified: Sun, 22 Mar 2020 19:28:02 GMT
                                 Connection: keep-alive
                                 ETag: W/"5e77bc42-22"
                                 Content-Encoding: gzip

* view /etc/nginx/conf.d dir     kubectl exec fortune-configmap-volume -c web-server ls /etc/nginx/conf.d
                                 my-nginx-config.conf
                                 sleep-interval
                                 work-hours-per-week

### Exposing certain configMap entries in the volume

* Able to populate a configMap volume with only part of the ConfigMap’s entries

* "items" attribute defines which entries should be exposed as files in a configMap volume.

* set the filename for each individual entry, along with the entry’s key.

* items                          volumes:
                                 - name: config
                                   configMap:
                                     name: fortune-config
                                     items:
                                     - key: my-nginx-config.conf
                                       path: gzip.conf

### Understanding that mounting a directory hides existing files in that directory

* When you mount a volume as a directory, it hides any files that are stored in
  the directory in the container image itself.

* The original files in that directory are inaccessible for as long as the
  filesystem is mounted.

### MOUNTING INDIVIDUAL CONFIGMAP ENTRIES AS FILES WITHOUT HIDING OTHER FILES IN THE DIRECTORY

* subPath (property)
  * pod.spec.containers.volumeMounts.subPath
  * Path within the volume from which the container's volume should be mounted.
  * ""         default

  * Allows you to mount either a single file or a single directory from the
    volume instead of mounting the whole volume.

  * Can be used when mounting any kind of volume. Instead of mounting the whole
    volume, you can mount part of it.

  spec:
    containers:
    - image: some/image
      volumeMounts:
      - name: myvolume
        mountPath: /etc/someconfig.conf  // You’re mounting into a file, not a directory.
        subPath: myconfig.conf           // Instead of mounting the whole volume,
                                         // you’re only mounting the myconfig.conf entry.

### SETTING THE FILE PERMISSIONS FOR FILES IN A CONFIGMAP VOLUME

* The default permissions on all files in a configMap volume are set to 644 (-rw-r—r--).

* defaultMode (property)
  * pod.spec.volumes.configMap.defaultMode
  * Sets file permission on creation
  * integer value        Must be a value between 0 and 0777
                         Defaults is 0644 (-rw-r—r--).
                         1 Execute
                         2 Write
                         4 Read

    volumes:
    - name: config
      configMap:
        name: fortune-config
        defaultMode: "0660"     // This sets the permissions for all files to 660 (-rw-rw---).

### Updating an app’s config without having to restart the app

* Using a ConfigMap and exposing it through a volume brings the ability to
  update the configuration without having to recreate the pod or even restart
  the container.

* Can take up to one whole minute.

* Edit confiMap to turn to       $ kubectl edit configmap fortune-config
  switching gzip compression off

* Change the gzip on line to gzip off

* confirm file changed           $ kubectl exec fortune-configmap-volume -c web-server cat /etc/nginx/conf.d/my-nginx-config.conf

* Signaling Nginx to             $ kubectl exec fortune-configmap-volume -c web-server -- nginx -s reload
  reload the config              2020/03/22 21:59:48 [notice] 25#25: signal process started

* invoke curl cmd                $ curl -H "Accept-Encoding: gzip"  -I localhost:8080
                                 Response is no longer compressed. 
                                 It no longer contains the Content-Encoding: gzip.

### UNDERSTANDING HOW THE FILES ARE UPDATED ATOMICALLY

* All files are updated atomically. All updates occur at once.

* Kubernetes achieves this by using symbolic links.

* List all the files in the mounted configMap volume:

$ kubectl exec -it fortune-configmap-volume -c web-server -- ls -lA /etc/nginx/conf.d
total 4
drwxr-xr-x    2 root     root          4096 Mar 22 21:40 ..2020_03_22_21_40_18.734918403
lrwxrwxrwx    1 root     root            31 Mar 22 21:40 ..data -> ..2020_03_22_21_40_18.734918403
lrwxrwxrwx    1 root     root            27 Mar 22 19:23 my-nginx-config.conf -> ..data/my-nginx-config.conf
lrwxrwxrwx    1 root     root            21 Mar 22 19:23 sleep-interval -> ..data/sleep-interval
lrwxrwxrwx    1 root     root            26 Mar 22 19:23 work-hours-per-week -> ..data/work-hours-per-week

* When the ConfigMap is updated, Kubernetes creates a new directory, writes all
  the files to it, and then re-links the ..data symbolic link to the  new 
  directory, effectively changing all files at once.

### UNDERSTANDING THAT FILES MOUNTED INTO EXISTING DIRECTORIES DON’T GET UPDATED

* If you’ve mounted a single file in the container instead of the whole volume,
  the file will not be updated!

### UNDERSTANDING THE CONSEQUENCES OF UPDATING A CONFIGMAP

* App may not support reloading its configuration.
* After configMap change and app does support reloading of configuration 
  * Old pods do not have change
  * New pods will have change
  * Restarted pods will have change

## 7.5 Using Secrets to pass sensitive data to containers

* Secret
  * A Kubernetes object used to store sensitive information securely
    * credentials
    * private encryption keys
    * etc
  * Maps that hold key-value pairs
  * They can be used the same way as a ConfigMap.
    * Can pass Secret entries to the container as environment variables.
    * Can expose Secret entries as files in a volume.
  * Secret is only distributed to the nodes that run the pods that
    need access to the Secret.
  * On the nodes themselves, Secrets are always stored in memory and
    never written to physical storage.

* Choose when to use a Secret or a ConfigMap.
  * Use a ConfigMap to store non-sensitive, plain configuration data.
  * Use a Secret to store any data that is sensitive in nature and
    needs to be kept under key. If a config file includes both
    sensitive and not-sensitive data, you should store the file in
    a Secret.

### Introducing the default token Secret

* A Secret is mounted into every container you run.
* Every pod has a secret volume attached to it automatically.

* list Secret                    $ kubectl describe pod
   (namespace is default)        ...
                                 Volumes:
                                   default-token-q25h5:
                                     Type:        Secret (a volume populated by a Secret)
                                     SecretName:  default-token-q25h5
                                     Optional:    false

* list default token             $ kubectl get secrets --all-namespaces
                                 NAME                  TYPE                                  DATA   AGE
                                 default-token-q25h5   kubernetes.io/service-account-token   3      142d

* describe secret                $ kubectl describe secret/default-token-q25h5
                                 Name:         default-token-q25h5
                                 Namespace:    default
                                 Labels:       <none>
                                 Annotations:  kubernetes.io/service-account.name: default
                                               kubernetes.io/service-account.uid: 1a363726-fcce-11e9-a2d7-025000000001
                                 
                                 Type:  kubernetes.io/service-account-token
                                 
                                 Data
                                 ====
                                 token:      eyJhbGciOiJSUzI1NiIsImtpZCI6IiJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJkZWZhdWx0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6ImRlZmF1bHQtdG9rZW4tcTI1aDUiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC5uYW1lIjoiZGVmYXVsdCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50LnVpZCI6IjFhMzYzNzI2LWZjY2UtMTFlOS1hMmQ3LTAyNTAwMDAwMDAwMSIsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDpkZWZhdWx0OmRlZmF1bHQifQ.AyHu7s6aQb-TDFrAGy6h_WQ-umlIQ4SHSiFBTtGuGeqS5tr-Lcv9uNV8MN4V65Kc-Zeq0pJQHKNNh2ImezUs2RfxXvIav7sBSMQSsWpMRtL9pTjNJvFt2HlgaJy6tnM0YyMhMfs1qbRlAHUyP6k82JwQp7A9KHppXlsxTfpb6qU5GD7pTWBxNkHBomAyh2OGw2YwrruXELz1FkQze9qWv9BXW5Wxfl5PDZHIori80ozyqgLw0m3AL40fSiOsyavn3srVMUZen7J7wIeWwHSoRUD6v5OWSxNmMYYidZQoxheiPTMXEPrjuCeBzwdPTg6QtdCyMBSoxYTXD1fhTdmRIA
                                 ca.crt:     1025 bytes
                                 namespace:  7 bytes

* where the secret volume       $ kubectl describe pod fortune-configmap-volume
  is mounted                    Mounts:
                                  /var/run/secrets/kubernetes.io/serviceaccount from default-token-q25h5 (ro)

* automountServiceAccountToken (property)
  * pod.spec.automountServiceAccountToken
  * Indicates whether a service account token Secret should be automatically
    mounted on each container.
  * True        token is mounted; default
  * False       disables mounting of token

  * Disables mounting of default-token Secret on a container.
  * Default behavior is default-token Secret is mounted on every container.

* check contents of            $ kubectl exec pod/fortune-configmap-volume ls /var/run/secrets/kubernetes.io/serviceaccount/
  Secret volume                ca.crt
                               namespace
                               token

* create https.key             $ openssl genrsa -out https.key 2048

* create https.cert            $ openssl req -new -x509 -key https.key -out https.cert -days 3650 -subj /CN=www.kubia-example.com

* create foo                   $ echo bar > foo

* create a Secret              $ kubectl create secret generic fortune-https --from-file=https.key --from-file=https.cert --from-file=foo
                               secret/fortune-https created
                               Note: Can pass individual files, or directory.

### Comparing ConfigMaps and Secrets

* view yaml of Secret          $ kubectl get secret fortune-https -o yaml
                               apiVersion: v1
                               data:
                                 foo: YmFyCg==
                                 https.cert: LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tL...
                                 https.key: LS0tLS1CRUdJTiBSU0EgUFJJVkFURSBLRV...
                               kind: Secret
                               ...

* view yaml of ConfigMap      $ kubectl get configmap fortune-config -o yaml
                              apiVersion: v1
                              data:
                                my-nginx-config.conf: |
                                  server {
                                      listen              80;
                                      server_name         www.kubia-example.com;
                              
                                      gzip off;
                                      gzip_types text/plain application/xml;
                              
                                      location / {
                                          root   /usr/share/nginx/html;
                                          index  index.html index.htm;
                                      }
                              
                                  }
                                sleep-interval: |
                                  25
                                work-hours-per-week: |
                                  80
                              kind: ConfigMap

* Differences
  * Secret’s entries are shown as Base64-encoded
  * ConfigMap entries are shown in clear text
  * A Secret’s entries can contain binary values
  * Base64 encoding allows you to include the binary data in YAML or JSON
  * Maximum size of a Secret is limited to 1MB.

### INTRODUCING THE STRINGDATA FIELD

* stringData (property)
  * secret.stringData
  * Specifying non-binary secret data in string form
  * <key>: <string>          String data 

* data (property)
  * secret.stringData
  * Data contains the secret data. Each key must consist of alphanumeric
    characters, '-', '\_' or '.'. The serialized form of the secret data is a
    base64 encoded string, representing the arbitrary data value here.

    kind: Secret
    apiVersion: v1
    stringData:
      foo: plain text
    data:
      https.cert: LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSURCekNDQ...
      https.key: LS0tLS1CRUdJTiBSU0EgUFJJVkFURSBLRVktLS0tLQpNSUlFcE...

  * Can only be used to set values
  * The stringData field is write-only
  * When you retrieve the Secret’s YAML with kubectl get -o yaml, the stringData
    field will not be shown.
  * All entries you specified in the stringData field will be shown under data
    and will be Base64-encoded like all the other entries.

### READING A SECRET’S ENTRY IN A POD

* When you expose the Secret to a container through a secret volume, the value
  of the Secret entry is decoded and written to the file in its actual form.
* The app doesn’t need to decode it.

### Using the Secret in a pod

* Configures the server to read the certificate and key files from 
  /etc/nginx/certs, so you’ll need to mount the secret volume there.

* edit Secret                    $ kubectl edit configmap fortune-config
                                 configmap/fortune-config edited

* Modify the part that defines the contents of the my-nginxconfig.conf entry so
  it looks like the following listing. 

server {
    listen              80;
    listen              443 ssl;
    server_name         www.kubia-example.com;

    ssl_certificate     certs/https.cert;
    ssl_certificate_key certs/https.key;
    ssl_protocols       TLSv1 TLSv1.1 TLSv1.2;
    ssl_ciphers         HIGH:!aNULL:!MD5;

    gzip on;
    gzip_types text/plain application/xml;

    location / {
        root   /usr/share/nginx/html;
        index  index.html index.htm;
    }
...

* This configures the server to read the certificate and key files from
  /etc/nginx/certs, so you’ll need to mount the secret volume there.

* mount the fortune-https secret in a pod

* fortune-pod-https.yaml

apiVersion: v1
kind: Pod
metadata:
  name: fortune-https
spec:
  containers:
  - image: luksa/fortune:env
    name: html-generator
    env:
    - name: INTERVAL
      valueFrom: 
        configMapKeyRef:
          name: fortune-config
          key: sleep-interval
    volumeMounts:
    - name: html
      mountPath: /var/htdocs
  - image: nginx:alpine
    name: web-server
    volumeMounts:
    - name: html
      mountPath: /usr/share/nginx/html
      readOnly: true
    - name: config
      mountPath: /etc/nginx/conf.d
      readOnly: true
    - name: certs                         // You configured Nginx to read the cert and
      mountPath: /etc/nginx/certs/        // key file from /etc/nginx/certs, so you need
      readOnly: true                      // to mount the Secret volume there.
    ports:
    - containerPort: 80
    - containerPort: 443
  volumes:
  - name: html
    emptyDir: {}
  - name: config
    configMap:
      name: fortune-config
      items:
      - key: my-nginx-config.conf
        path: https.conf
  - name: certs                          // You define the secret
    secret:                              // volume here, referring to
      secretName: fortune-https          // the fortune-https Secret.

* create pod                     $ kubectl create -f fortune-pod-https.yaml
                                 pod/fortune-https created

* Like configMap volumes, secret volumes also support specifying file
  permissions for the files exposed in the volume through the defaultMode
  property.

* opening a portforward          $ kubectl port-forward fortune-https 8443:443 & 
  tunnel to the pod’s port 443   Forwarding from 127.0.0.1:8443 -> 443
                                 Forwarding from [::1]:8443 -> 443

* send a request to the server   $ curl https://localhost:8443 -k
  with curl:                     There is no distinctly native American criminal class except Congress.
                                 -- Mark Twain

* show server’s certificate      $ curl https://localhost:8443 -k -v
                                 ...
                                 * Server certificate:
                                 *  subject: CN=www.kubia-example.com
                                 *  start date: Mar 24 16:27:25 2020 GMT
                                 *  expire date: Mar 22 16:27:25 2030 GMT
                                 *  issuer: CN=www.kubia-example.com
                                 *  SSL certificate verify result: self signed certificate (18), continuing anyway.
                                 ...

### UNDERSTANDING SECRET VOLUMES ARE STORED IN MEMORY

* The secret volume uses an in-memory filesystem (tmpfs) for the Secret files.
* Because tmpfs is used, the sensitive data stored in the Secret is never
  written to disk, where it could be compromised.

* view mount tmpfs               $ kubectl exec fortune-https -c web-server -- mount | grep certs
                                 tmpfs on /etc/nginx/certs type tmpfs (ro,relatime)

### EXPOSING A SECRET’S ENTRIES THROUGH ENVIRONMENT VARIABLES

* Instead of using a volume, you could also have exposed individual entries
  from the secret as environment variables,

  env:
  - name: FOO_SECRET          // The variable should be set from the entry of a Secret.
    valueFrom:
      secretKeyRef:
        name: fortune-https   // The name of the Secret holding the key
        key: foo              // The key of the Secret to expose

* configMap uses    configMapKeyRef property
* secret uses       secretKeyRef property

* Although can do, not good idea because
  * Applications usually dump environment variables in error reports
  * Applications write env vars to the application log at startup
  * Child processes (i.e. third-party binary) inherit all the environment
    variables of the parent process

### Understanding image pull Secrets

* Sometimes Kubernetes itself requires you to pass credentials to it, i.e.
* For example, when using images from a private container image registry

### USING A PRIVATE IMAGE REPOSITORY ON DOCKER HUB

* To run a pod, which uses an image from the private repository, you need to do
  two things:

  1. Create a Secret holding the credentials for the Docker registry.
  2. Reference that Secret in the imagePullSecrets field of the pod manifest.

* CREATING A SECRET FOR AUTHENTICATING WITH A DOCKER REGISTRY

* create docker-registry Secret  $ kubectl create secret docker-registry mydockerhubsecret \
                                 --docker-username=myusername \
                                 --docker-password=mypassword \
                                 --docker-email=my.email@provider.com

* show secret yaml               $ kubectl get secret/mydockerhubsecret -o yaml
                                 apiVersion: v1
                                 data:
                                   .dockerconfigjson: eyJhdXRocyI6eyJodHRwczovL2luZGV4LmRvY2tlci5pby92MS8iOnsidXNlcm5hbWUiOiJteXVzZXJuYW1lIiwicGFzc3dvcmQiOiJteXBhc3N3b3JkIiwiZW1haWwiOiJteS5lbWFpbEBwcm92aWRlci5jb20iLCJhdXRoIjoiYlhsMWMyVnlibUZ0WlRwdGVYQmhjM04zYjNKayJ9fX0=
                                 kind: Secret
                                 metadata:
                                   creationTimestamp: "2020-03-24T19:17:16Z"
                                   name: mydockerhubsecret
                                   namespace: default
                                   resourceVersion: "7399659"
                                   selfLink: /api/v1/namespaces/default/secrets/mydockerhubsecret
                                   uid: 12f3c05a-6e04-11ea-99d1-025000000001
                                 type: kubernetes.io/dockerconfigjson

### USING THE DOCKER-REGISTRY SECRET IN A POD DEFINITION

* specify the Secret’s           apiVersion: v1
  name in the pod spec           kind: Pod
                                 metadata:
                                   name: private-pod
                                 spec:
                                   imagePullSecrets:             // This enables pulling images 
                                   - name: mydockerhubsecret     // from a private image registry.
                                   containers:
                                   - image: username/private:tag
                                     name: main

* imagePullSecrets (property)
  * pod.spec.imagePullSecrets
  * Specify the Secret’s name in the pod spec. An optional list of references to
    secrets in the same namespace to use for pulling any of the images used by
    this PodSpec. If specified, these secrets will be passed to individual
    puller implementations for them to use.
  * - <key>: <value>

* Pull Secrets can be added to all your pods automatically if you add the 
  Secrets to a ServiceAccount.

# Chapter 8: Accessing pod metadata and other resources from applications

## 8.1 Passing metadata through the Downward API

### Kubernetes Downward API

* Used to acquired information about a resource after is created
* Is a way of having environment variables or files populated with values from
  the pod’s specification or status.
* Information includes:
  * The pod’s name
  * The pod’s IP address
  * The namespace the pod belongs to
  * The name of the node the pod is running on
  * The name of the service account the pod is running under
  * The CPU and memory requests for each container
  * The CPU and memory limits for each container
  * The pod’s labels
  * The pod’s annotations

* Service Account
  * Is the account that the pod authenticates when talking to the API server.

### Exposing metadata through environment variables

* pod.spec.containers.env.valueFrom.fieldRef.fieldPath
* pod.spec.containers.env.valueFrom.resourceFieldRef.resource

* downward-api-env.yaml          apiVersion: v1
                                 kind: Pod
                                 metadata:
                                   name: downward
                                 spec:
                                   containers:
                                   - name: main
                                     image: busybox
                                     command: ["sleep", "9999999"]
                                     resources:
                                       requests:
                                         cpu: 15m
                                         memory: 100Ki
                                       limits:
                                         cpu: 100m
                                         memory: 4Mi
                                     env:
                                     - name: POD_NAME                           <--
                                       valueFrom:
                                         fieldRef:
                                           fieldPath: metadata.name
                                     - name: POD_NAMESPACE                      <--
                                       valueFrom:
                                         fieldRef:
                                           fieldPath: metadata.namespace
                                     - name: POD_IP                             <--
                                       valueFrom:
                                         fieldRef:
                                           fieldPath: status.podIP
                                     - name: NODE_NAME                          <--
                                       valueFrom:
                                         fieldRef:
                                           fieldPath: spec.nodeName
                                     - name: SERVICE_ACCOUNT                    <--
                                       valueFrom:
                                         fieldRef:
                                           fieldPath: spec.serviceAccountName
                                     - name: CONTAINER_CPU_REQUEST_MILLICORES   <--
                                       valueFrom:
                                         resourceFieldRef:
                                           resource: requests.cpu
                                           divisor: 1m
                                     - name: CONTAINER_MEMORY_LIMIT_KIBIBYTES   <--
                                       valueFrom:
                                         resourceFieldRef:
                                           resource: limits.memory
                                           divisor: 1Ki

* create pod                     $ kubectl create -f downward-api-env.yaml
                                 pod/downward created

* view env vars                  $ kubectl exec downward -- env | sort
                                 CONTAINER_CPU_REQUEST_MILLICORES=15            <--
                                 CONTAINER_MEMORY_LIMIT_KIBIBYTES=4096          <--
                                 HOME=/root
                                 HOSTNAME=downward
                                 KUBERNETES_PORT=tcp://10.96.0.1:443
                                 KUBERNETES_PORT_443_TCP=tcp://10.96.0.1:443
                                 KUBERNETES_PORT_443_TCP_ADDR=10.96.0.1
                                 KUBERNETES_PORT_443_TCP_PORT=443
                                 KUBERNETES_PORT_443_TCP_PROTO=tcp
                                 KUBERNETES_SERVICE_HOST=10.96.0.1
                                 KUBERNETES_SERVICE_PORT=443
                                 KUBERNETES_SERVICE_PORT_HTTPS=443
                                 KUBIA_PORT=tcp://10.108.250.163:80
                                 KUBIA_PORT_80_TCP=tcp://10.108.250.163:80
                                 KUBIA_PORT_80_TCP_ADDR=10.108.250.163
                                 KUBIA_PORT_80_TCP_PORT=80
                                 KUBIA_PORT_80_TCP_PROTO=tcp
                                 KUBIA_SERVICE_HOST=10.108.250.163
                                 KUBIA_SERVICE_PORT=80
                                 NODE_NAME=docker-desktop                       <--
                                 PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
                                 POD_IP=10.1.2.215                              <--
                                 POD_NAME=downward                              <--
                                 POD_NAMESPACE=default                          <--
                                 SERVICE_ACCOUNT=default                        <--

### Passing metadata through files in a downwardAPI volume

* Must use a downwardAPI volume for exposing the pod’s labels or its annotations,
  because neither can be exposed through environment variables.

* pod.spec.volumes.downwardAPI.items.fieldRef.fieldPath
* pod.spec.volumes.downwardAPI.items.resourceFieldRef.resource

* downward-api-volume.yaml       apiVersion: v1
                                 kind: Pod
                                 metadata:
                                   name: downward
                                   labels:
                                     foo: bar  
                                   annotations:
                                     key1: value1
                                     key2:
                                       multi
                                       line
                                       value
                                 spec:
                                   containers:
                                   - name: main
                                     image: busybox
                                     command: ["sleep", "9999999"]
                                     resources:
                                       requests:
                                         cpu: 15m 
                                         memory: 100Ki
                                       limits:
                                         cpu: 100m
                                         memory: 4Mi
                                     volumeMounts:
                                     - name: downward
                                       mountPath: /etc/downward
                                   volumes:
                                   - name: downward
                                     downwardAPI:
                                       items:
                                       - path: "podName"
                                         fieldRef:
                                           fieldPath: metadata.name             <--
                                       - path: "podNamespace"
                                         fieldRef:
                                           fieldPath: metadata.namespace        <--
                                       - path: "labels" 
                                         fieldRef:
                                           fieldPath: metadata.labels           <--
                                       - path: "annotations"
                                         fieldRef:
                                           fieldPath: metadata.annotations
                                       - path: "containerCpuRequestMilliCores"  <--
                                         resourceFieldRef:
                                           containerName: main
                                           resource: requests.cpu               <--
                                           divisor: 1m                          // 1m
                                       - path: "containerMemoryLimitBytes"      // 1 (one whole core), 1m (one milli-core, or one one-thousandth of a CPU core)
                                         resourceFieldRef:
                                           containerName: main
                                           resource: limits.memory              <--
                                           divisor: 1Ki                         // 1Ki
                                                                                // 1 (byte), 1k or 1Ki (kilobyte), 1M or 1Mi (megabyte), and so on.

* create pod                     $ kubectl create -f downward-api-volume.yaml
                                 pod/downward-vol created

* list env vars                  $ kubectl exec downward-vol -- ls -lA /etc/downward
                                 annotations
                                 containerCpuRequestMilliCores
                                 containerMemoryLimitBytes
                                 labels
                                 podName
                                 podNamespace

* cat volume files               $ kubectl exec downward-vol -- cat /etc/downward/annotations
                                 key1="value1"
                                 key2="multi\nline\nvalue\n"
                                 kubernetes.io/config.seen="2020-03-25T20:43:55.9060542Z"
                                 kubernetes.io/config.source="api"

                                 $ kubectl exec downward-vol -- cat /etc/downward/containerCpuRequestMilliCores
                                 15

                                 $ kubectl exec downward-vol -- cat /etc/downward/containerMemoryLimitBytes
                                 4096

                                 $ kubectl exec downward-vol -- cat /etc/downward/labels
                                 foo="bar"

                                 $ kubectl exec downward-vol -- cat /etc/downward/podName
                                 downward-vol

                                 $ kubectl exec downward-vol -- cat /etc/downward/podNamespace
                                 default
                                 Note: If you leave off namespace: in original yaml, it defaults to "default".

### UPDATING LABELS AND ANNOTATIONS

* Labels and annotations can be modified while a pod is running.
* But environment variables can not be modified while a pod is running.
* That is why labels and annotations can not be exposed as environment
  variables. Must use downwardAPI volume to expose.

### REFERRING TO CONTAINER-LEVEL METADATA IN THE VOLUME SPECIFICATION

* Container name must be specified
* Because volumes are defined at the pod level, not at the container level.
* True even for single-container pods

* With environment variables, resources limits and requests can only be passed
  within a container.

* With volumes, resources limits and requests can be passed to all containers
  in the pod.

spec:
  volumes:
  - name: downward
    downwardAPI:
      items:
      - path: "containerCpuRequestMilliCores"
        resourceFieldRef:
          containerName: main               // Container name must be specified
          resource: requests.cpu
          divisor: 1m

### UNDERSTANDING WHEN TO USE THE DOWNWARD API

* Downward API keeps application Kubernetes-agnostic
* Useful when application uses environment variables

## 8.2 Talking to the Kubernetes API server

* Used when 
  * To know more about other pods and other resources defined in the cluster.
  * Requires access to the most up-to-date information as possible.

### Exploring the Kubernetes REST API

* Get URL for Kubernetes API     $ kubectl cluster-info
                                 Kubernetes master is running at https://kubernetes.docker.internal:6443
                                 KubeDNS is running at https://kubernetes.docker.internal:6443/api/v1/namespaces/kube-system/services/kube-dns:dns/proxy

* Try to access                  $ curl -k -I https://kubernetes.docker.internal:6443
  (without authentication)       HTTP/2 403 Forbidden


### ACCESSING THE API SERVER THROUGH KUBECTL PROXY

* Talk to the API server from your local machine, using the kubectl proxy.

* The kubectl proxy command runs a proxy server that accepts HTTP connections on
  your local machine and proxies them to the API server while taking care of 
  authentication, so you don’t need to pass the authentication token in every
  request.

* run the proxy                  $ kubectl proxy
                                 Starting to serve on 127.0.0.1:8001

* send request to the proxy      $ curl localhost:8001
                                 {
                                   "paths": [
                                     "/api",
                                     "/api/v1",
                                     "/apis",
                                     "/apis/",
                                     "/apis/admissionregistration.k8s.io",
                                     "/apis/admissionregistration.k8s.io/v1beta1",
                                     "/apis/apiextensions.k8s.io",
                                     "/apis/apiextensions.k8s.io/v1beta1",
                                     "/apis/apiregistration.k8s.io",
                                     "/apis/apiregistration.k8s.io/v1",
                                     "/apis/apiregistration.k8s.io/v1beta1",
                                     "/apis/apps",
                                     "/apis/apps/v1",
                                     "/apis/apps/v1beta1",
                                     "/apis/apps/v1beta2",
                                     "/apis/authentication.k8s.io",
                                     "/apis/authentication.k8s.io/v1",
                                     "/apis/authentication.k8s.io/v1beta1",
                                     "/apis/authorization.k8s.io",
                                     "/apis/authorization.k8s.io/v1",
                                     "/apis/authorization.k8s.io/v1beta1",
                                     "/apis/autoscaling",
                                     "/apis/autoscaling/v1",
                                     "/apis/autoscaling/v2beta1",
                                     "/apis/autoscaling/v2beta2",
                                     "/apis/batch",
                                     "/apis/batch/v1",
                                     "/apis/batch/v1beta1",
                                     "/apis/certificates.k8s.io",
                                     "/apis/certificates.k8s.io/v1beta1",
                                     "/apis/compose.docker.com",
                                     "/apis/compose.docker.com/v1alpha3",
                                     "/apis/compose.docker.com/v1beta1",
                                     "/apis/compose.docker.com/v1beta2",
                                     "/apis/coordination.k8s.io",
                                     "/apis/coordination.k8s.io/v1",
                                     "/apis/coordination.k8s.io/v1beta1",
                                     "/apis/events.k8s.io",
                                     "/apis/events.k8s.io/v1beta1",
                                     "/apis/extensions",
                                     "/apis/extensions/v1beta1",
                                     "/apis/kafka.strimzi.io",
                                     "/apis/kafka.strimzi.io/v1alpha1",
                                     "/apis/kafka.strimzi.io/v1beta1",
                                     "/apis/networking.k8s.io",
                                     "/apis/networking.k8s.io/v1",
                                     "/apis/networking.k8s.io/v1beta1",
                                     "/apis/node.k8s.io",
                                     "/apis/node.k8s.io/v1beta1",
                                     "/apis/policy",
                                     "/apis/policy/v1beta1",
                                     "/apis/rbac.authorization.k8s.io",
                                     "/apis/rbac.authorization.k8s.io/v1",
                                     "/apis/rbac.authorization.k8s.io/v1beta1",
                                     "/apis/scheduling.k8s.io",
                                     "/apis/scheduling.k8s.io/v1",
                                     "/apis/scheduling.k8s.io/v1beta1",
                                     "/apis/storage.k8s.io",
                                     "/apis/storage.k8s.io/v1",
                                     "/apis/storage.k8s.io/v1beta1",
                                     "/healthz",
                                     "/healthz/autoregister-completion",
                                     "/healthz/etcd",
                                     "/healthz/log",
                                     "/healthz/ping",
                                     "/healthz/poststarthook/apiservice-openapi-controller",
                                     "/healthz/poststarthook/apiservice-registration-controller",
                                     "/healthz/poststarthook/apiservice-status-available-controller",
                                     "/healthz/poststarthook/bootstrap-controller",
                                     "/healthz/poststarthook/ca-registration",
                                     "/healthz/poststarthook/crd-informer-synced",
                                     "/healthz/poststarthook/generic-apiserver-start-informers",
                                     "/healthz/poststarthook/kube-apiserver-autoregistration",
                                     "/healthz/poststarthook/rbac/bootstrap-roles",
                                     "/healthz/poststarthook/scheduling/bootstrap-system-priority-classes",
                                     "/healthz/poststarthook/start-apiextensions-controllers",
                                     "/healthz/poststarthook/start-apiextensions-informers",
                                     "/healthz/poststarthook/start-kube-aggregator-informers",
                                     "/healthz/poststarthook/start-kube-apiserver-admission-initializer",
                                     "/logs",
                                     "/metrics",
                                     "/openapi/v2",
                                     "/version"
                                   ]
                                 }

* the Job resource API           $ curl http://localhost:8001/apis/batch

                                 $ curl http://localhost:8001/apis/batch/v1
                                 {
                                   "kind": "APIResourceList",
                                   "apiVersion": "v1",
                                   "groupVersion": "batch/v1",
                                   "resources": [
                                     {
                                       "name": "jobs",
                                       "singularName": "",
                                       "namespaced": true,
                                       "kind": "Job",
                                       "verbs": [
                                         "create",
                                         "delete",
                                         "deletecollection",
                                         "get",
                                         "list",
                                         "patch",
                                         "update",
                                         "watch"
                                       ],
                                       "categories": [
                                         "all"
                                       ]
                                     },
                                     {
                                       "name": "jobs/status",
                                       "singularName": "",
                                       "namespaced": true,
                                       "kind": "Job",
                                       "verbs": [
                                         "get",
                                         "patch",
                                         "update"
                                       ]
                                     }
                                   ]
                                 }

* list of all Jobs in cluster    $ curl http://localhost:8001/apis/batch/v1/jobs

### RETRIEVING A SPECIFIC JOB INSTANCE BY NAME

* list a specific Job            $ curl http://localhost:8001/apis/batch/v1/namespaces/<name>/jobs/<name>
                                 $ curl http://localhost:8001/apis/batch/v1/namespaces/default/jobs/my-job
                                 same as ...
                                 $ kubectl get job my-job -o yaml

### Talking to the API server from within a pod

* Talk to the API server from within a pod, where you (usually) don’t have kubectl.

* Three things required to talk to the API server from inside a pod
  1. Find the location of the API server.
  2. Make sure you’re talking to the API server and not something impersonating it.
  3. Authenticate with the server; otherwise it won’t let you see or do anything.

* How an app running inside a pod can access the Kubernetes API properly:

  1. The app should verify whether the API server’s certificate is signed by the
     certificate authority, whose certificate is in the ca.crt file.

  2. The app should authenticate itself by sending the Authorization header with
     the bearer token from the token file.

  3. The namespace file should be used to pass the namespace to the API server
     when performing CRUD operations on API objects inside the pod’s namespace.

    ========  ============
    CRUD      HTTP Request
    ========  ============
    Create    POST
    Read      GET
    Update    PATCH/PUT
    Delete    DELETE

#### Create a pod to communicate with the API Server

* Docker Hub tutum/curl image (has curl) to be used to 
  a) Run the sleep command in its only container
  b) Run a shell in the container with kubectl exec


* curl.yaml                      apiVersion: v1
                                 kind: Pod
                                 metadata:
                                   name: curl
                                 spec:
                                   containers:
                                   - name: main
                                     image: tutum/curl
                                     command: ["sleep", "9999999"]

* create pod                     $ kubectl create -f curl.yaml 
                                 pod/curl created


* run a bash shell in container  $ kubectl exec -it curl bash
                                 root@curl:/#

#### Find the API Server's address

* Find the IP and port of the Kubernetes API server
* A Service called kubernetes is automatically exposed in the default namespace
  and configured to point to the API server.

* list kubernetes svc            $ kubectl get svc kubernetes
                                 NAME         TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)   AGE
                                 kubernetes   ClusterIP   10.96.0.1        <none>        443/TCP   146d

* You can get both the IP address and the port of the API server by looking
up the KUBERNETES_SERVICE_HOST and KUBERNETES_SERVICE_PORT variables (inside
the container).

* get host and port              $ env | grep KUBERNETES_SERVICE
                                 KUBERNETES_SERVICE_PORT=443
                                 KUBERNETES_SERVICE_HOST=10.96.0.1
                                 KUBERNETES_SERVICE_PORT_HTTPS=443


* try hitting the server         $ curl https://kubernetes
  through HTTPS                  curl: (60) SSL certificate problem: unable to get local issuer certificate

#### Verify the server's identity

* A Secret is automatically created for each container called "default-token-xyz"
  mounted at "/var/run/secrets/kubernetes.io/serviceaccount/".

* view contents of Secret        $ curl:/# ls /var/run/secrets/kubernetes.io/serviceaccount/
                                 ca.crt namespace  token

* To verify you’re talking to the API server, you need to check if the server’s
certificate is signed by the CA. curl allows you to specify the CA certificate
with the --cacert option.        
                                 $ curl --cacert /var/run/secrets/kubernetes.io/serviceaccount/ca.crt https://kubernetes
                                 [Book] Unauthorized 
                                 [Me]   "code": 403 forbidden

* Made progress, but Unauthorized response means need to take care of 
  authentication. 1st make life easier by setting the CURL_CA_BUNDLE environment
  variable.
                                 $ export CURL_CA_BUNDLE=/var/run/secrets/kubernetes.io/serviceaccount/ca.crt

* Now hit the API server without using --cacert.
                                 
                                 $ curl https://kubernetes
                                 [Book] Unauthorized 
                                 [Me]   "code": 403 forbidden

#### Authenticating with the API Server

* To authenticate, use the authentication token. 1st load the token into an
  environment variable.
                                 $ export TOKEN=$(cat /var/run/secrets/kubernetes.io/serviceaccount/token)

* Sending request to API         $ curl -H "Authorization: Bearer $TOKEN" https://kubernetes
                                 {
                                   "paths": [
                                     "/api",
                                     "/api/v1",
                                     ...

#### Disabling role-based access control (RBAC)

* If using a Kubernetes cluster with RBAC enabled, the service account may not
  be authorized to access (parts of) the API server. To work around RBAC, use:

                                 $ kubectl create clusterrolebinding permissive-binding \
                                   -clusterrole=cluster-admin \
                                   -group=system:serviceaccounts

#### Getting the namespace the pod is running in

* Load contents Secrets namespace file into env var

                                 $ export NS=$(cat /var/run/secrets/kubernetes.io/serviceaccount/namespace)

* list all the pods              $ curl -H "Authorization: Bearer $TOKEN" https://kubernetes/api/v1/namespaces/$NS/pods
                                 {
                                   "kind": "PodList",
                                   "apiVersion": "v1",
                                 ...

* In the same manner, you could also retrieve other API objects and even update
  them by sending PUT or PATCH instead of simple GET requests.

### Simplifying API server communication with ambassador containers

* The app in the main container can connect to the ambassador through HTTP 
  (instead of HTTPS) and let the ambassador proxy handle the HTTPS connection to
  the API server.

* Offloading encryption, authentication, and server verification to kubectl
  proxy in an ambassador container.

* Pro: The ambassador container is reusable across many different apps,
  regardless of what language the main app is written in.

* Con: The downside is that an additional process is running and consuming 
  additional resources.

#### Create pod

* curl-with-ambassador.yaml      apiVersion: v1
                                 kind: Pod
                                 metadata:
                                   name: curl-with-ambassador
                                 spec:
                                   containers:
                                   - name: main
                                     image: tutum/curl
                                     command: ["sleep", "9999999"]
                                   - name: ambassador
                                     image: luksa/kubectl-proxy:1.6.2

* create pod                     $ kubectl create -f curl-with-ambassador.yaml
                                 pod/curl-with-ambassador created

* enter the main container       $ kubectl exec -it curl-with-ambassador -c main bash
                                 root@curl-with-ambassador:/#

#### Talking to the API Server through the ambassador

* By default, kubectl proxy binds to port 8001
* Containers in the pod share the same network interfaces

* point curl to localhost:8001   $ curl localhost:8001
                                 {
                                   "paths": [
                                     "/api",
                                     "/api/v1",
                                 ...

### Using client libraries to talk to the API server

* To perform a few simple operations on the API server, then use 
  kubectl-proxy ambassador container.

* More than simple API requests, then use an existing Kubernetes API client
  libraries.

  1. Golang client—https://github.com/kubernetes/client-go

  2. Python—https://github.com/kubernetes-incubator/client-python

* Kubernetes community has a number of Special Interest Groups (SIGs)
  * https://github.com/kubernetes/community/blob/master/sig-list.md

### AN EXAMPLE OF INTERACTING WITH KUBERNETES WITH THE FABRIC8 JAVA CLIENT
* Skipped

### BUILDING YOUR OWN LIBRARY WITH SWAGGER AND OPENAPI
* Skipped


# Chapter 9: Deployments: updating applications declaratively

* Deployments facilitate
  * Update of pps running in a Kubernetes cluster
  * Helps you move toward a true zero-downtime update process
  * Deployment resources sit on top of ReplicaSets enables declarative
    application updates.

## 9.1 Updating applications running in pods

### Option #1: Deleting old pods and replacing them with new ones

* Process: 
  * Pod template of a ReplicationController can be updated at any time.
  * When the ReplicationController creates new instances, it uses the
    updated pod template to create them.

* Drawback: 
  * Leads to a short period of time when your application is unavailable.

### Option #2: Spinning up new pods and then deleting the old ones

* Process:
  * You can do this either by adding all the new pods and then deleting all the
    old ones at once, or sequentially, by adding new pods and removing old ones
    gradually.

* Drawback: 
  * Requires your app to handle running two versions of the app at the same
    time. If your app stores data in a data store, the new version shouldn’t
    modify the data schema or the data in such a way that breaks the previous
    version.
  * Will require more hardware resources.


#### SWITCHING FROM THE OLD TO THE NEW VERSION AT ONCE

* blue-green deployment
  * Pods are fronted by a Service/Replication Controller
  * Have the Service/Replication Controller front only the initial version of the pods
  * Bring up a new Replication Controller running the new Pod version
  * Once all the new pods are up, change the Service’s label selector and have
    the Service switch over to the new Replication Controller/Pods.

#### PERFORMING A ROLLING UPDATE

* Slowly scaling down the previous ReplicationController and scaling up the new
  one.

* Service’s pod selector to include both the old and the new pods, so it directs
  requests toward both sets of pods.

* Manual rolling update: Laborious and error-prone

* Automated rolling update: Done with on command. 
  * Using kubectl to perform the update makes the process much easier, but, as
    you’ll see later, this is now an outdated way of updating apps.

## 9.2 Performing an automatic rolling update with a ReplicationController

### yaml file

* YAML files can contain multiple resource definitions separated by a line with
  three dashes, i.e. Chapter09/kubia-rc-and-service-v1.yaml

### Pushing updates to the same image tag

* If new image and not latest, push to repository with new tag. Else Pods created with same
  (old) tag will not get updated.

* imagePullPolicy
  * Image pull policy.
  * One of Always, Never, IfNotPresent. 
  * Defaults to Always if :latest tag is specified, 
    Defaults to IfNotPresent when tag not :latest
  * Cannot be updated.
  * pod.spec.containers.imagePullPolicy
 
  * If new image and not latest, push to repository with new tag. Else Pods
    created with same (old) tag will not be updated. Work around, is
    "imagePullPolicy: Always".

### Understanding why kubectl rolling-update is now obsolete

* Kubernetes modifying the labels of my pods and the label selectors of 
  ReplicationControllers is something that is unexpected.

* The kubectl client is the one doing the scaling, instead of it being performed
  by the Kubernetes master. If you lost network connectivity while kubectl was
  performing the update, the update process would be interrupted mid-way.
  Pods and ReplicationControllers would end up in an intermediate state.

* Another reason why performing an update like this isn’t as good as it could
  be is because it’s imperative. Kubernetes is about you telling it the desired
  state of the system and having Kubernetes achieve that state on its own, by
  figuring out the best way to do it.

* Declarative: You want to change the desired image tag in your pod definitions
  and have Kubernetes replace the pods with new ones running the new image.

### logging -v 6

* Using the --v 6 option increases the logging level enough to let you see
  the requests kubectl is sending to the API server. 

## 9.3 Using Deployments for updating apps declaratively

* Deployment
  * A higher-level resource meant for deploying applications and updating them
    declaratively, instead of doing it through a ReplicationController or a
    ReplicaSet, which are both considered lower-level concepts.

* ReplicaSets are a new generation of ReplicationControllers.

* Resources relationships

  +--------------+       +-----------------------------------------------------------+
  | Service      | --->  |                                                           |
  | ClusterIP    |       |                                                           |
  +--------------+       |  +------------+      +------------+      +-------------+  |
                         |  | Deployment | ---> | ReplicaSet | ---> |     Pods    |  |
  +--------------+       |  +------------+      +------------+      +-------------+  |
  | Service      | --->  |                                                           |
  | LoadBalancer |       |                                                           |
  +--------------+       +-----------------------------------------------------------+

* Using a Deployment instead of the lower-level constructs makes updating an app
  much easier, because you’re defining the desired state through the single
  Deployment resource and letting Kubernetes take care of the rest.

* The Deployment can have multiple pod versions running under its wing, so its
  name shouldn’t reference the app version.

### Creating a Deployment

* reset Kubernetes               Use Docker Preference Reset menu

* kubia-svc-v02.yaml             apiVersion: v1
                                 kind: Service
                                 metadata:
                                   name: kubia
                                 spec:
                                   ports:
                                   - port: 80
                                     targetPort: 8080
                                   selector:
                                    app: kubia

* create kubia service           $ kubectl create -f ../Chapter05/kubia-svc-v02.yaml
                                 service/kubia created

* kubia-svc-loadbalancer-v02.yaml  apiVersion: v1
                                   kind: Service
                                   metadata:
                                     name: kubia-loadbalancer
                                   spec:
                                     type: LoadBalancer
                                     ports:
                                     - port: 80
                                       targetPort: 8080
                                     selector:
                                       app: kubia

* create load balancer           $ kubectl create -f ../Chapter05/kubia-svc-loadbalancer-v02.yaml

* kubia-deployment-v1.yaml       apiVersion: apps/v1beta1
                                 kind: Deployment
                                 metadata:
                                   name: kubia
                                 spec:
                                   replicas: 3
                                   template:
                                     metadata:
                                       name: kubia
                                       labels:
                                         app: kubia
                                     spec:
                                       containers:
                                       - image: luksa/kubia:v1
                                         name: nodejs

* create deployment              $ kubectl create -f kubia-deployment-v1.yaml --record
                                 deployment.apps/kubia created

* check deployment               (OLD WAY)
                                 $ kubectl get -o wide --show-labels services 
                                 NAME                 TYPE           CLUSTER-IP       EXTERNAL-IP   PORT(S)        AGE   SELECTOR    LABELS
                                 kubernetes           ClusterIP      10.96.0.1        <none>        443/TCP        21m   <none>      component=apiserver,provider=kubernetes
                                 kubia                ClusterIP      10.99.254.118    <none>        80/TCP         13m   app=kubia   <none>
                                 kubia-loadbalancer   LoadBalancer   10.101.238.175   localhost     80:31412/TCP   85s   app=kubia   <none>

                                 $ kubectl get -o wide --show-labels deployment 
                                 NAME    READY   UP-TO-DATE   AVAILABLE   AGE   CONTAINERS   IMAGES           SELECTOR    LABELS
                                 kubia   3/3     3            3           62s   nodejs       luksa/kubia:v1   app=kubia   app=kubia

                                 $ kubectl get -o wide --show-label ReplicaSets
                                 NAME               DESIRED   CURRENT   READY   AGE   CONTAINERS   IMAGES           SELECTOR                                 LABELS
                                 kubia-5dfcbbfcff   3         3         3       80s   nodejs       luksa/kubia:v1   app=kubia,pod-template-hash=5dfcbbfcff   app=kubia,pod-template-hash=5dfcbbfcff

                                 $ kubectl get -o wide --show-labels pods 
                                 NAME                     READY   STATUS    RESTARTS   AGE    IP          NODE             NOMINATED NODE   READINESS GATES   LABELS
                                 kubia-5dfcbbfcff-9hhz4   1/1     Running   0          119s   10.1.3.73   docker-desktop   <none>           <none>            app=kubia,pod-template-hash=5dfcbbfcff
                                 kubia-5dfcbbfcff-fdjgw   1/1     Running   0          119s   10.1.3.72   docker-desktop   <none>           <none>            app=kubia,pod-template-hash=5dfcbbfcff
                                 kubia-5dfcbbfcff-rbsqm   1/1     Running   0          119s   10.1.3.71   docker-desktop   <none>           <none>            app=kubia,pod-template-hash=5dfcbbfcff

                                 $ kubectl describe deployment
                                 Name:                   kubia
                                 Namespace:              default
                                 CreationTimestamp:      Wed, 01 Apr 2020 14:51:58 -0700
                                 Labels:                 app=kubia
                                 Annotations:            deployment.kubernetes.io/revision: 1
                                                         kubernetes.io/change-cause: kubectl create --filename=kubia-deployment-v1.yaml --record=true
                                 Selector:               app=kubia
                                 Replicas:               3 desired | 3 updated | 3 total | 3 available | 0 unavailable
                                 StrategyType:           RollingUpdate
                                 MinReadySeconds:        0
                                 RollingUpdateStrategy:  25% max unavailable, 25% max surge
                                 Pod Template:
                                   Labels:  app=kubia
                                   Containers:
                                    nodejs:
                                     Image:        luksa/kubia:v1
                                     Port:         <none>
                                     Host Port:    <none>
                                     Environment:  <none>
                                     Mounts:       <none>
                                   Volumes:        <none>
                                 Conditions:
                                   Type           Status  Reason
                                   ----           ------  ------
                                   Available      True    MinimumReplicasAvailable
                                   Progressing    True    NewReplicaSetAvailable
                                 OldReplicaSets:  <none>
                                 NewReplicaSet:   kubia-5dfcbbfcff (3/3 replicas created)
                                 Events:
                                   Type    Reason             Age   From                   Message
                                   ----    ------             ----  ----                   -------
                                   Normal  ScalingReplicaSet  3m1s  deployment-controller  Scaled up replica set kubia-5dfcbbfcff to 3


                                 (NEW WAY)
                                 $ kubectl rollout status deployment kubia
                                 deployment "kubia" successfully rolled out

                                 $  kubectl rollout history deployment kubia
                                 deployment.extensions/kubia
                                 REVISION  CHANGE-CAUSE
                                 1         kubectl create --filename=kubia-deployment-v1.yaml --record=true

* check connection               $ curl http://localhost:80
                                 This is v1 running in pod kubia-5dfcbbfcff-9hhz4
                                 This is v1 running in pod kubia-5dfcbbfcff-rbsqm
                                 This is v1 running in pod kubia-5dfcbbfcff-fdjgw

### UNDERSTANDING HOW DEPLOYMENTS CREATE REPLICASETS, WHICH THEN CREATE THE PODS

* A Deployment creates multiple ReplicaSets, one for each version of the pod template.

* ReplicaSet and pods contain hash value of its pod template within their name.

* Using the hash value of the pod template like this allows the Deployment to
  always use the same (possibly existing) ReplicaSet for a given version of the
  pod template.

### Updating a Deployment

* The only thing you need to do is modify the pod template defined in the
  Deployment resource and Kubernetes will take all the steps necessary to get
  the actual system state to what’s defined in the resource.

#### Modifying an existing resource in Kubernetes

* All these methods are equivalent as far as Deployments go. What they do is
  change the Deployment’s specification. This change then triggers the rollout
  process.

+-------------------+----------------------------------------------------------+
| kubectl edit      | Opens the object’s manifest in your default editor.      |
|                   | After making changes, saving the file, and exiting the   |
|                   | editor, the object is updated.                           |
|                   |                                                          |
|                   | $ kubectl edit deployment kubia                          |
+-------------------+----------------------------------------------------------+
| kubectl patch     | Modifies individual properties of an object.             |
|                   |                                                          |
|                   | $ kubectl patch deployment kubia -p '{"spec":            |
|                   |   {"template": {"spec": {"containers": [{"name":         |
|                   |   "nodejs", "image": "luksa/kubia:v2"}]}}}}'             |
+-------------------+----------------------------------------------------------+
| kubectl apply     | Modifies the object by applying property values from a   |
|                   | full YAML or JSON file. If the object specified in the   |
|                   | YAML/JSON doesn’t exist yet, it’s created. The file      |
|                   | needs to contain the full definition of the resource     |
|                   | (it can’t include only the fields you want to update, as |
|                   | is the case with kubectl patch).                         |
|                   |                                                          |
|                   |$ kubectl apply -f kubia-deployment-v2.yaml               |
+-------------------+----------------------------------------------------------+
| kubectl replace   | Replaces the object with a new one from a YAML/JSON      |
|                   | file. In contrast to the apply command, this command     |
|                   | requires the object to exist; otherwise it prints an     |
|                   | error.                                                   |
|                   |                                                          |
|                   | $ kubectl replace -f kubia-deployment-v2.yaml            |
+-------------------+----------------------------------------------------------+
| kubectl set image | Changes the container image defined in a Pod,            |
|                   | ReplicationController’s template, Deployment, DaemonSet, |
|                   | Job, or ReplicaSet.                                      |
|                   |                                                          |
|                   | $ kubectl set image deployment kubia                     |
|                   |   nodejs=luksa/kubia:v2                                  |
+-------------------+----------------------------------------------------------+

#### SLOWING DOWN THE ROLLING UPDATE FOR DEMO PURPOSES

* StrategyType (property)
  * deployment.spec.strategy.type
  * Sets the Deployment strategy configuration
  * RollingUpdate     Perform a rolling update; default value
                      Removes old pods one by one, while adding new ones at the
                      same time
  * Recreate          Deletes all the old pods at once and then creates new ones
                      Use when application doesn’t support running multiple
                      versions in parallel

* minReadySeconds (property)
  * deployment.spec.minReadySeconds
  * Minimum number of seconds for which a newly created pod should be ready
    without any of its container crashing, for it to be considered available.
  * <integer>          Default 0, pod will be considered available as soon as it
                       is ready

* set minReadySeconds to 10      $ kubectl patch deployment kubia -p '{"spec": {"minReadySeconds": 10}}'
                                 deployment.extensions/kubia patched

check feild                      $ kubectl describe deployment
                                 ...
                                 MinReadySeconds:        10
                                 ...

* This doesn’t cause any kind of update to the pods, because you didn’t change
  the pod "template". Changing other Deployment properties, like the desired
  "replica" count or the deployment "strategy", also doesn’t trigger a rollout,
  because it doesn’t affect the existing individual pods in any way.

* show updated yaml              $ kubectl get deployment kubia -o yaml
                                 apiVersion: extensions/v1beta1
                                 kind: Deployment
                                 metadata:
                                   annotations:
                                     deployment.kubernetes.io/revision: "1"
                                     kubernetes.io/change-cause: kubectl create --filename=kubia-deployment-v1.yaml
                                       --record=true
                                   creationTimestamp: "2020-04-01T21:51:58Z"
                                   generation: 2
                                   labels:
                                     app: kubia
                                   name: kubia
                                   namespace: default
                                   resourceVersion: "2600"
                                   selfLink: /apis/extensions/v1beta1/namespaces/default/deployments/kubia
                                   uid: 029700fd-7463-11ea-b35b-025000000001
                                 spec:
                                   minReadySeconds: 10                 <--
                                   progressDeadlineSeconds: 600
                                   replicas: 3                         <--
                                   revisionHistoryLimit: 2
                                   selector:
                                     matchLabels:
                                       app: kubia
                                   strategy:
                                     rollingUpdate:
                                       maxSurge: 25%
                                       maxUnavailable: 25%
                                     type: RollingUpdate               <--
                                   template:                           <--
                                     metadata:
                                       creationTimestamp: null
                                       labels:
                                         app: kubia
                                       name: kubia
                                     spec:
                                       containers:
                                       - image: luksa/kubia:v1
                                 ...

#### TRIGGERING THE ROLLING UPDATE

* loop call for container kubia  $ while true; do curl http://localhost:80; done
                                 This is v1 running in pod kubia-5dfcbbfcff-rc2th
                                 This is v1 running in pod kubia-5dfcbbfcff-b2q7t
                                 This is v1 running in pod kubia-5dfcbbfcff-dpnc2
                                 ...

* change image v1 to v2          $ kubectl set image deployment kubia nodejs=luksa/kubia:v2
                                 deployment "kubia" image updated
                                 ...
                                 This is v2 running in pod kubia-7c699f58dd-n84qt
                                 This is v2 running in pod kubia-7c699f58dd-qtqpm
                                 This is v2 running in pod kubia-7c699f58dd-qsgwp
                                 ...

* You’ll see requests initially hitting only the v1 pods; then more and more of
  them hit the v2 pods until, finally, all of them hit only the remaining v2
  pods, after all v1 pods are deleted. This works much like the rolling update
  performed by kubectl.

* check rs                       $ kubectl get -o wide --show-labels ReplicaSets
                                 NAME               DESIRED   CURRENT   READY   AGE     CONTAINERS   IMAGES           SELECTOR                                 LABELS
                                 kubia-5dfcbbfcff   0         0         0       22m     nodejs       luksa/kubia:v1   app=kubia,pod-template-hash=5dfcbbfcff   app=kubia,pod-template-hash=5dfcbbfcff
                                 kubia-7c699f58dd   3         3         3       2m36s   nodejs       luksa/kubia:v2   app=kubia,pod-template-hash=7c699f58dd   app=kubia,pod-template-hash=7c699f58dd

* check revisions                $ kubectl rollout history deployment kubia
                                 REVISION  CHANGE-CAUSE
                                 1         kubectl create --filename=kubia-deployment-v1.yaml --record=true
                                 2         kubectl create --filename=kubia-deployment-v1.yaml --record=true

#### UNDERSTANDING THE AWESOMENESS OF DEPLOYMENTS

* Changed a single filed
* The controllers running as part of the Kubernetes control plane then performed
  the update.
* Did not have to run a special command telling Kubernetes what to do and then
  waiting around for the process to be completed.
* NOTE Be aware that if the pod template in the Deployment references a
  ConfigMap (or a Secret), modifying the ConfigMap will not trigger an
  update. One way to trigger an update when you need to modify an app’s config
  is to create a new ConfigMap and modify the pod template so it references
  the new ConfigMap.
* You created and operated only on the Deployment resource; the underlying
  ReplicaSets are an implementation detail.

#### Rolling back a deployment

* Deploy version 3 with bug      $ kubectl set image deployment kubia nodejs=luksa/kubia:v3
                                 deployment.extensions/kubia image updated

* loop call for container kubia  $ while true; do curl http://localhost:80; done
                                 ...
                                 Some internal error has occurred! This is pod kubia-5c98f77977-8wfrg
                                 Some internal error has occurred! This is pod kubia-5c98f77977-2dggn
                                 Some internal error has occurred! This is pod kubia-5c98f77977-lb5jk
                                 ...

* check revisions                $ kubectl rollout history deployment kubia
                                 deployment.extensions/kubia
                                 REVISION  CHANGE-CAUSE
                                 1         kubectl create --filename=kubia-deployment-v1.yaml --record=true
                                 2         kubectl create --filename=kubia-deployment-v1.yaml --record=true
                                 3         kubectl create --filename=kubia-deployment-v1.yaml --record=true

* show ReplicaSets               $ kubectl get -o wide --show-labels ReplicaSets
                                 NAME               DESIRED   CURRENT   READY   AGE     CONTAINERS   IMAGES           SELECTOR                                 LABELS
                                 kubia-5c98f77977   3         3         3       4m47s   nodejs       luksa/kubia:v3   app=kubia,pod-template-hash=5c98f77977   app=kubia,pod-template-hash=5c98f77977
                                 kubia-5dfcbbfcff   0         0         0       30m     nodejs       luksa/kubia:v1   app=kubia,pod-template-hash=5dfcbbfcff   app=kubia,pod-template-hash=5dfcbbfcff
                                 kubia-7c699f58dd   0         0         0       10m     nodejs       luksa/kubia:v2   app=kubia,pod-template-hash=7c699f58dd   app=kubia,pod-template-hash=7c699f58dd


* undo the last rollout          $ kubectl rollout undo deployment kubia
                                 ...
                                 This is v2 running in pod kubia-7c699f58dd-fnzp7
                                 This is v2 running in pod kubia-7c699f58dd-s5gdz
                                 This is v2 running in pod kubia-7c699f58dd-w6w6j
                                 ...

* show ReplicaSets               $ kubectl get -o wide --show-labels ReplicaSets
                                 NAME               DESIRED   CURRENT   READY   AGE     CONTAINERS   IMAGES           SELECTOR                                 LABELS
                                 kubia-5c98f77977   0         0         0       8m24s   nodejs       luksa/kubia:v3   app=kubia,pod-template-hash=5c98f77977   app=kubia,pod-template-hash=5c98f77977
                                 kubia-5dfcbbfcff   0         0         0       33m     nodejs       luksa/kubia:v1   app=kubia,pod-template-hash=5dfcbbfcff   app=kubia,pod-template-hash=5dfcbbfcff
                                 kubia-7c699f58dd   3         3         3       14m     nodejs       luksa/kubia:v2   app=kubia,pod-template-hash=7c699f58dd   app=kubia,pod-template-hash=7c699f58dd


* deployment history             $ kubectl rollout history deployment kubia
                                 deployment.extensions/kubia
                                 REVISION  CHANGE-CAUSE
                                 1         kubectl create --filename=kubia-deployment-v1.yaml --record=true
                                 3         kubectl create --filename=kubia-deployment-v1.yaml --record=true
                                 4         kubectl create --filename=kubia-deployment-v1.yaml --record=true

* TIP The undo command can also be used while the rollout process is still in
  progress to essentially abort the rollout.

* When a rollout completes, the old ReplicaSet isn’t deleted, and this enables
  rolling back to any revision, not only the previous one.

#### DISPLAYING A DEPLOYMENT’S ROLLOUT HISTORY

* display revision history       $ kubectl rollout history deployment kubia
                                 (book says)
                                 deployments "kubia":
                                 REVISION CHANGE-CAUSE
                                 2 kubectl set image deployment kubia nodejs=luksa/kubia:v2
                                 3 kubectl set image deployment kubia nodejs=luksa/kubia:v3

                                 (mine says)
                                 deployment.extensions/kubia
                                 REVISION  CHANGE-CAUSE
                                 1         kubectl create --filename=kubia-deployment-v1.yaml --record=true
                                 3         kubectl create --filename=kubia-deployment-v1.yaml --record=true
                                 4         kubectl create --filename=kubia-deployment-v1.yaml --record=true

* The "--record" command-line option during "create deployment" makes CHANGE-CAUSE column visible.

#### ROLLING BACK TO A SPECIFIC DEPLOYMENT REVISION

* roll back to a specific        $ kubectl rollout undo deployment kubia --to-revision=1
  revision

* You can roll back to a specific revision by specifying the revision in the
  undo command.

* A ReplicaSet exists for each version. Do not delete, else will be unable to 
  roll back to that version.

* revisionHistoryLimit (property)
  * deployment.spec.revisionHistoryLimit
  * The number of old ReplicaSets to retain to allow rollback.
  * integer value       extensions/v1beta1     doesn’t have a default
                        apps/v1beta1           default 2
                        apps/v1beta2           default 10
                        2147483647             max value of int32, i.e. all

#### Controlling the rate of the rollout

* The way new pods are created and old ones are deleted is configurable through
  two additional properties of the rolling update strategy.

* maxSurge (property)
  * deployment.spec.strategy.rollingUpdate.maxSurge
  * Determines how many pod instances you allow to exist above the desired
    replica count configured on the Deployment.
  * string              1, default
                        absolute number (ex: 5) or a 
                        percentage of desired pods (ex: 10%!)(MISSING)

* maxUnavailable
  * deployment.spec.strategy.rollingUpdate.maxUnavailable
  * Determines how many pod instances can be unavailable relative to the desired
    replica count during the update.
  * string              1, default

    spec:
      strategy:
        rollingUpdate:
          maxSurge: 1
          maxUnavailable: 0
        type: RollingUpdate

#### Pausing the rollout process

* What you want is to run a single v4 pod next to your existing v2 pods and see
  how it behaves with only a fraction of all your users. Then, once you’re sure
  everything’s okay, you can replace all the old pods with new ones.

* change image to                $ kubectl set image deployment kubia nodejs=luksa/kubia:v4
  to luksa/kubia:v4              deployment "kubia" image updated

* pause the rollout              $ kubectl rollout pause deployment kubia
                                 deployment "kubia" paused

* display rs                     $ kubectl get -o wide --show-labels replicasets
                                 NAME               DESIRED   CURRENT   READY   AGE   CONTAINERS   IMAGES           SELECTOR                                 LABELS
                                 kubia-5c98f77977   0         0         0       16m   nodejs       luksa/kubia:v3   app=kubia,pod-template-hash=5c98f77977   app=kubia,pod-template-hash=5c98f77977
                                 kubia-6976f5b8f8   1         1         1       38s   nodejs       luksa/kubia:v4   app=kubia,pod-template-hash=6976f5b8f8   app=kubia,pod-template-hash=6976f5b8f8
                                 kubia-7c699f58dd   3         3         3       22m   nodejs       luksa/kubia:v2   app=kubia,pod-template-hash=7c699f58dd   app=kubia,pod-template-hash=7c699f58dd

* display revision history       $ kubectl rollout history deployment kubia
                                 deployment.extensions/kubia
                                 REVISION  CHANGE-CAUSE
                                 3         kubectl create --filename=kubia-deployment-v1.yaml --record=true
                                 4         kubectl create --filename=kubia-deployment-v1.yaml --record=true
                                 5         kubectl create --filename=kubia-deployment-v1.yaml --record=true

* A single new pod should have been created, but all original pods should also
  still be running. Once the new pod is up, a part of all requests to the
  service will be redirected to the new pod.

* canary release
  * Is a technique for minimizing the risk of rolling out a bad version of an
    application and it affecting all your users. Instead of rolling out the new
    version to everyone, you replace only one or a small number of old pods with
    new ones. This way only a small number of users will initially hit the new
    version. You can then verify whether the new version

#### RESUMING THE ROLLOUT

* resume deployment              $ kubectl rollout resume deployment kubia
                                 deployment.extensions/kubia resumed

#### USING THE PAUSE FEATURE TO PREVENT ROLLOUTS

* Pausing a Deployment can also be used to prevent updates to the Deployment
  from kicking off the rollout process, allowing you to make multiple changes to
  the Deployment and starting the rollout only when you’re done making all the
  necessary changes. Once you’re ready for changes to take effect, you resume
  the Deployment and the rollout process will start.

* NOTE If a Deployment is paused, the undo command won’t undo it until you
  resume the Deployment.

#### Blocking rollouts of bad versions

* Until the pod is available, the rollout process will not continue

* A pod is ready when readiness probes of all its containers return a success.

* Use minReadySeconds to a high enough number to make sure pods keep reporting
  they’re ready after they’ve already started receiving actual traffic.

* Using minReadySeconds is like an airbag that saves your app from making a big
  mess after you’ve already let a buggy version slip into production.

* With a properly configured readiness probe and a proper minReadySeconds
  setting, Kubernetes would have prevented us from deploying the buggy v3 
  version earlier.

#### DEFINING A READINESS PROBE TO PREVENT OUR V3 VERSION FROM BEING ROLLED OUT FULLY

* Introduce a readiness probe with v3 with a readiness prob of application using 
kubia-deployment-v3-with-readinesscheck.yaml
                                 
                                 apiVersion: apps/v1beta1
                                 kind: Deployment
                                 metadata:
                                   name: kubia
                                 spec:
                                   replicas: 3
                                   minReadySeconds: 10
                                   strategy:
                                     rollingUpdate:
                                       maxSurge: 1
                                       maxUnavailable: 0
                                     type: RollingUpdate
                                   template:
                                     metadata:
                                       name: kubia
                                       labels:
                                         app: kubia
                                     spec:
                                       containers:
                                       - image: luksa/kubia:v3
                                         name: nodejs
                                         readinessProbe:
                                           periodSeconds: 1
                                           httpGet:
                                             path: /
                                             port: 8080

* update with apply              $ kubectl apply -f kubia-deployment-v3-with-readinesscheck.yaml




