[![Build Status](https://travis-ci.org/fabioformosa/j-metamorphosis.svg?branch=master)](https://travis-ci.org/fabioformosa/j-metamorphosis)

# METAMORPHOSIS (CONVERSIONS)

> "Nothing is lost, nothing is created, everything is transformed"
> _Lavoisier

**J-Metamorphosis** is the java version of [**Metamorphosis**](https://fabioformosa.github.io/metamorphosis), an utility library to ease conversions of objects, provided as java, javascript and NestJS as well. 

J-Metamorphosis is based on [**spring conversion service**](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#core-convert) that helps you to create converters from/to DTO/Entity or between DTOs.


It creates the [spring conversion service](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#core-convert-Spring-config) and registers all your [converters](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#core-convert-Converter-API). For DTO/Entity converters, let inherit from the base classes (`DefaultConverterToDTO`, `DefaultConverterToEntity`) to take advantage of automatically entity retrieve from DB. 


Furthermore, if you need a mapping between DTO and Entity fields, for example to create JPA specifications in order to add 'where clause' to HQL queries, you can use mapping annotations (`@MappedOnEntity`, `@MappedOnEntityField`) and `FieldMapingHelper` to get the mapping between <dto entity field, entity field path>.

![Chameleon - ph. Nandhu Kumar - pexels.com!](https://images.pexels.com/photos/312826/pexels-photo-312826.jpeg?auto=compress&cs=tinysrgb&h=325&w=470 "Chameleon - ph. Nandhu Kumar - pexels.com")

## QUICK START

### IMPORT LIB
Add to your pom.xml: `metamorphosis-core` or `metamorphosis-jpa` if you use jpa.

```
<dependency>
  <groupId>it.fabioformosa</groupId>
  <artifactId>metamorphosis-core</artifactId>
  <version>3.0.0</version>
</dependency>
```

or 

```
<dependency>
  <groupId>it.fabioformosa</groupId>
  <artifactId>metamorphosis-jpa</artifactId>
  <version>3.0.0</version>
</dependency>
```

### ENABLE METAMORPHIS CONVERTIONS
add `@EnableMetamorphosisConversions` to your spring boot config class

    @Configuration
    @EnableMetamorphosisConversions(basePackages = { "your.package" })
    @ComponentScan(basePackages = { "your.package" })
    @EntityScan(basePackages = { "your.package" })
    @EnableJpaRepositories(basePackages = { "your.package" })
    public class MetamorphosisExampleConfig {

    }
## WRITE YOUR CONVERTERS
### FROM DTO TO ENTITY

Entend `DefaultConverterToEntity`

    @Component
     public class ItemDTOToItemEntity extends DefaultConverterToEntity<ItemDTO, ItemEntity> {
	     private ItemJpaRepository itemJpaRepository;

	     @Override
	     protected JpaRepository getRepository() {
	       return itemJpaRepository;
	     }

		@Override
        protected void convert(ItemDTO source, ItemEntity target) {
           ItemEntity target = super.convert(source, target);
    
         //for not-matching fields by fieldname 
         target.setField(...);
       }
     }

### FROM ENTITY TO DTO

Extend `DefaultConverterToDTO`

    @Component
     public class ItemToItemDTO 
                extends DefaultConverterToDTO<ItemEntity, ItemDTO> {
    }
    
## USE METAMORPHIS CONVERTIONS

    @Component
    public class SampleService {
    
      @Resource
      private ConversionService conversionService;

    
      public SimpleDTO saveEntity(SimpleDTO simpleDTO) {
        SimpleEntity simpleEntity = conversionService.convert(simpleDTO, SimpleEntity.class);
        ... <use entity> ...
        return conversionService.convert(simpleEntity, SimpleDTO.class);
      }
    
    }
    
## DTOs/ENTITIES: HELPER FOR FIELD MAPPINGS
Usually DTOs are used to extract data from persistence layer. From DTO, it needs to build hibernate query criteria in order to apply filtering (e.g. filterable grids). For example, if you have in your frontend a filterable grid, your REST controller will receive a DTO with the values of the filter applied from the user. Your API must project this filter in JPA condition on your entity.

So, you need a mapping between DTO fieldnames and entity fieldnames.

`it.fabioformosa.metamorphosis.mappers.FieldMappingHelper` helps you to get a `map<String, String>` that binds a DTO fieldname to an entity fieldname (with dot notation, e.g. 'dto.foo' -> 'entity.foo').
To accomplish it, you should annotate your DTO with the annotation `it.fabioformosa.metamorphosis.mappers.MappedOnEntity`  and DTO fields with `it.fabioformosa.metamorphosis.mappers.MappedOnEntityField`, so you can invoke `FieldMappingHelper.getMappingByDTO(DTO.class)` to get mappings data you need to build the right JPA queries.
e.g. 

    ### ENTITY ###
	@Entity
	public class AuditedItemEntity {
	  private Long id;
	  private String name;

	  private String category;

	  private Location location;
	  private Location targetLocation;

	  private String itemTypeLabel;

	  private LocalDateTime createdDate;
	  private String creationUser;
	  private LocalDateTime lastModifyDate;
	  private String lastModifyUser;
      
      ... (getters and setters)...
	}
	
	### DTO ###	

	@MappedOnEntity(AuditedItemEntity.class)
	public class AuditItemDTO {

	  private Long id;

	  @MappedOnEntityField
	  private String name;

	  @MappedOnEntityField(entityField = "category")
	  private String categoryName;

	  @MappedOnEntityField(entityField = "location", cascade = true)
	  private LocationDTO locationDTO;

	  @MappedOnEntityField(entityField = "targetLocation.name")
	  private String targetLocationName;

	  @MappedOnEntityField(entityField = "itemTypeLabel", innerDtoField = "enumLabel", cascade = false)
	  private EnumDTO itemType;

	  @MappedOnEntityField(cascade = true, concatOnCascade = false)
	  private AuditDTO auditDTO;
	  
	  ...(getters and setters)
	  }

## HOW-TO UPGRADE METAMORPHOSIS VERSIONS ##

Look at the [CHANGELOG](https://github.com/fabioformosa/j-metamorphosis/blob/master/metamorphosis/CHANGELOG.md) to read all breaking changes before to bump metamorphosis version.

## EXAMPLES ##
For further details about how to use `j-metamorphosis`, look at this [sample project](https://github.com/fabioformosa/j-metamorphosis-example).

## CREDITS
Chameleon in this README file is a picture of ph. Nandhu Kumar (pexels.com)
