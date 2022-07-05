package br.com.roobox.chatbot.Yampi.Cart.Service;


import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CartService {

}

//<<<<<<< HEAD
//    public void abandonedCart(@NotEmpty() boolean cart, JsonNode rootNode) {
//        //////////////////////CARRINHO ABANDONADO
//        if (rootNode.get("event").asText().equals("cart.reminder") || cart) {
//            JSONObject jsonObject1 = insertCart(rootNode);
//            if (!jsonObject1.isEmpty())
//                new com.mr.RoboShopify.API.Database().insert(jsonObject1, "drop-carrinho-abandonado", clienteModel.getToken());
////        new ApiYampi_Content().carrinhoAbandonado(whatsappModel, yampiModel, jsonObject);
////////////////////////CARRINHO ABANDONADO
//        }
//    }
//
//    private JSONObject insertCart(JsonNode jsonObject) {
//        try {
//            jsonObject.get("resource").get("customer_id").asInt();
//        } catch (Exception e) {
//            return new JSONObject();
//        }
//
//        ProductEntity product = new ProductEntity();
//
//        System.out.println(LocalDateTime.now() + " - Webhook recebido: Carrinho Abandonado");
//
//        String produto;
//        try {
//            produto = jsonObject.getJSONObject("resource").getJSONObject("spreadsheet").getJSONObject("data").getString("products");
//        } catch (JSONException e) {
//            produto = jsonObject.getJSONObject("resource").getJSONObject("spreadsheet").getJSONArray("data").getJSONObject(0).getString("product");
//        }
//
//        String whatsapp;
//        try {
//            whatsapp = jsonObject.getJSONObject("resource").getJSONObject("spreadsheet").getJSONObject("data").getString("customer_phone");
//        } catch (Exception e) {
//
//            whatsapp = jsonObject.getJSONObject("resource").getJSONObject("spreadsheet").getJSONArray("data").getJSONObject(0).getString("customer_phone");
//        }
//
//        JSONObject pedidos = jsonObject.getJSONObject("resource");
//        carrinhoAbandonadoModel.setStatus(0);
//        carrinhoAbandonadoModel.setNumeroCarrinho(String.valueOf(pedidos.getLong("id")));
//        carrinhoAbandonadoModel.setUrlCarrinho(pedidos.getString("simulate_url"));
//        carrinhoAbandonadoModel.setCustomerId(pedidos.getInt("customer_id"));
//        carrinhoAbandonadoModel.setNomeCliente(pedidos.getJSONObject("customer").getJSONObject("data").getString("name"));
//        carrinhoAbandonadoModel.setNumeroCliente(whatsapp);
//        carrinhoAbandonadoModel.setNomeProduto(produto);
//        carrinhoAbandonadoModel.setCpf(pedidos.getJSONObject("customer").getJSONObject("data").getString("cpf"));
//
//        JSONObject jsonInsertPedidosModel = serializationUtils.transformaElementoJson(carrinhoAbandonadoModel);
//        jsonInsertPedidosModel.remove("id");
//        jsonInsertPedidosModel.remove("idCliente");
//        jsonInsertPedidosModel.remove("createdAt");
//
//        return jsonInsertPedidosModel;
//    }
//=======
//    @Autowired
//    CartRepository cartRepository;
//
//    public void abandonedCart(JsonNode rootNode, YampiEntity yampi) {
//        insertCart(rootNode, yampiEntity);
//    }
//
//    private void insertCart(JsonNode jsonObject, YampiEntity yampi) {
//
//        CartEntity cart = new CartEntity();
//        cart.setProducts(getProduct(new ProductEntity(), jsonObject));
//        cart.setCustomer(getCustomer(new CustomerEntity(), jsonObject));
//
//        cart.setUrlCart(jsonObject.get("resource").get("simulate_url").asText());
//        cart.setStatus(0);
//        cart.setYampi(yampi);
//        cart.setId(jsonObject.get("resource").get("id").asLong());
//
//        cartRepository.save(cart);
//    }
//
//    private Set<ProductEntity> getProduct(ProductEntity product, JsonNode jsonObject) {
//        String produto;
//        try {
//            produto = jsonObject.get("resource").get("spreadsheet").get("data").get("products").asText();
//        } catch (JSONException e) {
//            produto = jsonObject.get("resource").get("spreadsheet").get("data").get(0).get("product").asText();
//        }
//
//        product.setCustomerId();
//        product.setNomeProduto();
//        product.setCliente();
//        product.setDataCriacao();
//        product.setFormaPagamento();
//        product.setStatus();
//        product.setIdYampi();
//        product.setNumeroPedido();
//        product.setTotal();
//        product.setImagemProduto();
//        return product;
//    }
//
//    private CustomerEntity getCustomer(CustomerEntity customer, JsonNode jsonObject) {
//        customer.setCpf();
//        customer.setEmail();
//        customer.setId();
//        customer.setName();
//        customer.setPhone();
//        customer.setType();
//
//        String whatsapp;
//        try {
//            whatsapp = jsonObject.get("resource").get("spreadsheet").get("data").getString("customer_phone");
//        } catch (Exception e) {
//
//            whatsapp = jsonObject.get("resource").get("spreadsheet").getJSONArray("data").get(0).getString("customer_phone");
//        }
//        return customer;
//    }
//>>>>>>> origin/development
//}


