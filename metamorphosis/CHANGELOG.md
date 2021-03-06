# J-METAMORPHOSIS Changelog

### 3.0.0 ###

#### Breaking Changes ####

In order to publish j-metamorphosis to maven central repo, it needed to change the package.
So, to import j-metamorphosis 3.0.0, add to your pom.xml

```
<dependency>
  <groupId>it.fabioformosa</groupId>
  <artifactId>metamorphosis-core</artifactId>
  <version>3.0.0</version>
</dependency>
```

or if you use JPA

```
<dependency>
  <groupId>it.fabioformosa</groupId>
  <artifactId>metamorphosis-jpa</artifactId>
  <version>3.0.0</version>
</dependency>
```

and update all your class imports from `dev.metamorphosis` to `it.fabioformosa.metamorphosis`


### 2.1.2 ###

#### Fix ####
none

#### New Features or Enhancements ####
[Refs #3](https://github.com/fabioformosa/metamorphosis/issues/3) - Converted basePackage attribute in basePackages  
 

#### Breaking Changes ####
Change `@EnableMetamorphisisConversions(basePackage = "com.foo.bar")` in `@EnableMetamorphisisConversions(basePackages = "com.foo.bar")` 

### 2.0.1 ###

#### Fix ####
[Refs #2](https://github.com/fabioformosa/metamorphosis/issues/2) - Restricted component scan for fieldMapping Annotations to basePackage set in `@EnableMetamorphisisConversions`

#### New Features or Enhancements ####
Recommendation: add the basePackage containing your DTOs in @EnableMetamorphisisConversions annotation. e.g. `@EnableMetamorphisisConversions(basePackage = "com.foo.bar")`

#### Breaking Changes ####
none  

------

### 2.0.0 ###

#### New Features or Enhancements ####
[Refs #1](https://github.com/fabioformosa/metamorphosis/issues/1) - It allows to import metamorphosis in project without jpa dependency. For example, you can import metamorphosis in a module containing only DTOs

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

