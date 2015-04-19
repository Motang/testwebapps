webapp
===========

A J2EE project with Maven build, that contains seven sub-maven module:

```
-- common (a base classes set helps other module)
--domain (model for DAO or web layer)
  -- webapp-domain
-- dao (DAO layer, focus on DB access) 
  -- webapp-dao
--manager (communicate with the third application, such as connect to other system with web service. also transaction management here)
  -- webapp-manager
--service (business layer)
  -- webapp-service
--controller (access http controller here, focus on validate and convert domain into business layer)
  -- webapp-controller
--web (view layer)
  -- webapp-web
```
