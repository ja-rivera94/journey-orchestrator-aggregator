## Micronaut 3.8.6 Documentation

- [User Guide](https://docs.micronaut.io/3.8.6/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.8.6/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.8.6/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


## Feature rxjava2 documentation

- [Micronaut RxJava 2 documentation](https://micronaut-projects.github.io/micronaut-rxjava2/snapshot/guide/index.html)


docker build -t orchestrator-aggregator .     


docker run -d -i -t -e URL_POST='http://localhost:3001' -e URL_ROUTES='http://localhost:3002' -e URL_OFFERS='http://localhost:3003' --net=bridge all -p 8080:8080  --name journey-orchestrator-container orchestrator-aggregator  

