# METAMORPHOSIS Changelog

### 2.0.0 ###

#### New Features or Enhancements ####
Refs #1 - It allows to import metamorphosis in project without jpa dependency. For example, you can import metamorphosis in a module containing only DTOs

#### Breaking Changes ####
Change metamorphosis import into your pom.xml

from
	
		<dependency>
      		<groupId>dev.metamorphosis</groupId>
      		<artifactId>metamorphosis</artifactId>
      		<version>1.2.0</version>
    	</dependency>
    	
to `metamorphosis-jpa`

		<dependency>
      		<groupId>dev.metamorphosis</groupId>
      		<artifactId>metamorphosis-jpa</artifactId>
      		<version>2.0.0</version>
    	</dependency>
or to `metamorphosis-core` to avoid transitive dependency toward jpa

		<dependency>
      		<groupId>dev.metamorphosis</groupId>
      		<artifactId>metamorphosis-core</artifactId>
      		<version>2.0.0</version>
    	</dependency>


------

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

