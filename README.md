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
