# METAMORPHOSIS Changelog

### 1.1.2 ###

#### Fix ####
It doesn't create conversionService if it exists

#### New Features or Enhancements ####
added an optional attribute to @EnableMetamorphisisConversions to avoid conversionService creation

#### Breaking Changes ####
none  

------
### 1.1.1 ###

#### Fix ####
none

#### New Features or Enhancements ####
Entity Class is now not mandatory as value of @MappedOnEntity. Indeed, entities could be not in the classpath of the project that collects DTOs. 

#### Breaking Changes ####
none  

------

### 1.1.0 ###

#### Fix ####
none

#### New Features or Enhancements ####
Added annotations (@MappedOnEntity, @MappedOnEntityField) and FieldMappingHelper to have mapping data between DTOs and entities, for example, to create JPA specifications in order to fiter.

#### Breaking Changes ####
none  

------

