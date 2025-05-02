# Kubernetes

To create a pod with filename: `pod-name.yaml`
```
apiVersion: v1
kind: Pod
metadata:
	name: my-pod
spec:
	containers:
	- name: nginx
	  image: nginx:1.14.2
	  ports:
	  - containerPort: 80
```

- To create the pod, navigate to directory, run `kubectl apply -f pod-name.yaml` (-f to specify the file name) 
- We cannot modify the pod with the same name, `my-pod` in the above case
- `kubectl get pods` to get all pods running
- `kubectl get pods -w` will open in watch mode with live status updates

