# Java Virtual Machine Manager

Java Virtual Machine Manager è un applicazione WEB che permettere di allocare "macchine virtuali" in un determinato host.
Il progetto è sviluppato in:

1. Java, il nostro backend
2. Spring, una REST API per creare degli ENDPOINT che permettono di comunicare col backend
3. Libvirt, un libreria per gestire le VM
4. NGINX, un server web per hostare il frontend creato con HTLM, CSS e JavaScript
5. NoVNC, un tool per interagire tramite WEB con le VM
6. Docker, per creare un ambiente di sviluppo (Al momento solo il backend non è su containter)

E' necessario nell'host installare le seguenti dipendenze:

```bash
sudo apt update
sudo apt-get install qemu-system
sudo apt install libvirt-dev libvirt-daemon-system
sudo apt install libvirt-clients bridge-utils virt-manager
sudo adduser $USER libvirt
```

Verifica che QEMU e libvirt sono installati

```bash
find /usr -name "libvirt.so*"
qemu-system-x86_64 --version
systemctl status libvirtd
sudo systemctl start libvirtd
```

Attiva la default network

```bash
sudo virsh net-list --all
sudo virsh net-start default
```

Le classi individuate al momento sono:

1. Person
2. Student, extend Person
3. User, extend Peron
4. Organization
5. Enterprise, extend Organization
6. Business, extend Organization
7. Controller, per la gestione degli ENDPOINT
8. CorsConfig, per la gestione del CORS
9. QEMU la classe per la gestione dell'hypervisor
10. VirtManagerApplication, la classe principale

Ogni utente che si registra avrà dei crediti di partenza differenti, esempio:

1. Lo studente avrà a disposizione 100 crediti iniziali,
2. Business avrà a dispositzione la metà dei credti dello studente
3. Enterprice non avrà crediti a disposizione senza pagare

Ogni credito ha il prezzo di 1 Euro e ogni VM costa in base alle risorse che si vogliono allocare, ecco la formula:

`cost = (vCPU * RamInGB / StorageInGb) * 200`

StorageInGB e RamInGB deve essere sempre espresso in potenze di 2.
La gestione del costo è implementata tramite interfaccia Cost.

User is a Person
Student is a User
Business is a User
Enterprise is a User

RoadMap:

1. Aggiungere Login
2. Implementare Signup col DB
3. Implementare il DB
4. Aggiungere API per la gestione delle VM
5. Aggiungere noVNC alla dashboard

Link utili:
`https://www.ibm.com/it-it/topics/rest-apis`
`https://stackoverflow.blog/2020/03/02/best-practices-for-rest-api-design/`
