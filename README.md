# METAMORPHOSIS (CONVERSIONS)
This **java library** helps you to create converters based on **spring conversion service**.

> "Nothing is lost, nothing is created, everything is transformed"
> _Lavoisier

## QUICK START
### ENABLE METAMORPHIS CONVERTIONS
add `@EnableMetamorphosisConversions` to your spring boot config class

    @Configuration
    @ComponentScan(basePackages = { "your.package" })
    @EntityScan(basePackages = { "your.package" })
    @EnableJpaRepositories(basePackages = { "your.package" })
    @EnableMetamorphosisConversions
    public class MetamorphosisExampleConfig {

    }
## WRITE YOUR CONVERTERS
### FROM DTO TO ENTITY

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

    @Component
     public class ItemToItemDTO 
                extends DefaultConverterToDTO<ItemEntity, dev.metamorphosis.dtos.ItemDTO> {
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
Usually DTOs are used to extract data to build hibernate query criteria to apply filtering (e.g. filterable grids).
In this case, you need mapping data to get entity fieldname for each field of DTO.
`dev.metamorphosis.mappers.FieldMappingHelper` helps you to get a `map<String, String>` that binds a DTO fieldname to entity fieldname (with dot notation, e.g. 'dto.foo' -> 'entity.foo').
You should annotate your DTO with annotation `dev.metamorphosis.mappers.MappedOnEntity`  and fields with `dev.metamorphosis.mappers.MappedOnEntityField`, so you can invoke `FieldMappingHelper.getMappingByDTO(DTO.class)` to get mappings data you need.
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
