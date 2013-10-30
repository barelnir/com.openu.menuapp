package com.openu.menuapp.controller;


public class BaseEntityController {

	/* @Autowired
    private BaseEntityService baseEntityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("product",new Product());
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public <T extends BaseEntity> String save( Model model, T baseEntity) {
        BaseEntity existing = baseEntityService.findByUUID(baseEntity.getUuid());
        if (existing != null) {
            model.addAttribute("status", "exist");
            return "index";
        }
        baseEntityService.saveOrUpdate(baseEntity);
        model.addAttribute("saved", "success");
        return "index";
    }

//    @RequestMapping(value = "/search", method = RequestMethod.POST)
//    public <T extends BaseEntity> String search(Model model, T baseEntity) {
//        List<T> baseEntityList = baseEntityService.findByCriteria(criterion)(baseEntity.getUuid());
//        model.addAttribute("baseEntity", baseEntityList);
//        model.addAttribute("search", true);
//        return "index";
//    }

    @RequestMapping(value = "/edit/{uuid}", method = RequestMethod.GET)
    public String updateBaseEntity(Model model, @PathVariable UUID uuid) {
        BaseEntity baseEntity = baseEntityService.findByUUID(uuid);
        model.addAttribute("baseEntity", baseEntity);
        return "update";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String updateUser( Model model, Product product) {
//        baseEntityService.saveOrUpdate(baseEntity)(product);
//        model.addAttribute("saved", "success");
//        return "update";
//    }
//    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
//    public String deleteProduct(Model model, @PathVariable String productId) {
//        baseEntityService.deleteProduct(productId);
//        model.addAttribute("deleted", "success");
//        model.addAttribute("product", new Product());
//        return "index";
//    }
	*/
}
