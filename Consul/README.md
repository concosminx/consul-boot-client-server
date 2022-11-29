# Run Consul on Windows 

## download consul
`...`

## create json configuration file ([docs](https://developer.hashicorp.com/consul/docs/agent/config/config-files))
```json
{
   "log_level":"INFO",
   "server":true,
   "ports":{
      "http":8500,
      "dns":8600,
      "serf_lan":8301,
      "serf_wan":8302
   }
}
```

## create a data folder 
`...`

## run the agent (optional create a .pid file with the process id)
```bash
consul agent -server -advertise=127.0.0.1 -data-dir=./data -ui -config-file=consul.json  -bootstrap-expect 1 -bootstrap -pid-file=consul.pid
```

# Run Consul as Docker container ([docs](https://developer.hashicorp.com/consul/tutorials/day-0/docker-container-agents))

## start a detached container
```bash
docker run \
    -d \
    -p 8500:8500 \
    -p 8600:8600/udp \
    --name=csm-consul \
    consul agent -server -ui -node=server-1 -bootstrap-expect=1 -client=0.0.0.0
```

## check consul members
`docker exec <container_id> consul members`


## Modify key/values ([docs](https://developer.hashicorp.com/consul/commands/kv/put))
`consul kv put config/Consul-Service/mycfg.email johndoe@mail.com`


# Use CLI ([docs](https://developer.hashicorp.com/consul/commands))
