//package com.gdsd.sellpurchase.controller;
//
//import com.gdsd.sellpurchase.model.Product;
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//import javax.validation.Valid;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/product")
//public class ProductController {
//
//    @Autowired
//    MongoOperations mongoOperations;
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public List<Product> getAllProducts() {
//        Query query = new Query();
//        query.fields().exclude("description");
//        return mongoOperations.find(query, Product.class);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public Product getProductById(@PathVariable("id") ObjectId id) {
//        Query query = new Query(Criteria.where("_id").is(id));
//        return mongoOperations.findOne(query, Product.class);
//    }
//
//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    public List<Product> searchProducts(@RequestParam(value = "search", required = false) String search, @RequestParam(value = "order", required = false) String order) {
//
//        if (search == null) {
//            search = "";
//        }
//        if (order == null) {
//            order = "";
//        }
//        Query query = new Query();
//        query.limit(10);
//        if (order.equalsIgnoreCase("asc")) {
//            query.with(new Sort(Sort.Direction.ASC, "price"));
//        } else {
//            query.with(new Sort(Sort.Direction.DESC, "price"));
//        }
////        query.fields().exclude("description");
//        Criteria criteria = new Criteria();
//
//        criteria.orOperator(Criteria.where("title").regex(search, "i"), Criteria.where("description").regex(search, "i"));
//        query.addCriteria(criteria);
//
//        return mongoOperations.find(query, Product.class);
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public Product createProduct(@Valid @RequestBody Product product) {
//        product.set_id(ObjectId.get());
//        mongoOperations.save(product);
//        return product;
//    }
//
////    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
////    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
////        
////        File convertFile = new File("C:\\Users\\User\\Desktop\\upload\\" + file.getOriginalFilename());
////        convertFile.createNewFile();
////        try (FileOutputStream fout = new FileOutputStream(convertFile)) {
////            fout.write(file.getBytes());
////        }
////        return new ResponseEntity<>("File is uploaded Successfully", HttpStatus.OK);
////        
////    }
//
//}
