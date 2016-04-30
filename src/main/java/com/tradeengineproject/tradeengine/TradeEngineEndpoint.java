package com.tradeengineproject.tradeengine;

import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
public class TradeEngineEndpoint
{
    //    @Autowired
    //    private TradeEngineService tradeEngineService;
    //
    //    private final Logger logger = Logger.getLogger("TradeEngineEndpoint");
    //
    //
    //    private static final String TARGET_NAMESPACE = "http://operations.ws_bindings.tradeengine.tradeengineproject.com";
    //
    //    @PayloadRoot(localPart = "CreateProductRequest", namespace = TARGET_NAMESPACE)
    //    public @ResponsePayload com.tradeengineproject.tradeengine.ws_bindings.operations.CreateProductResponse createProduct(@RequestPayload CreateProductRequest request)
    //    {
    //        CreateProductResponse response = new CreateProductResponse();
    //
    //        Product product = new Product();
    //        product.setCommercialName(request.getCommercialName());
    //        product.setPrice(request.getPrice());
    //
    //        tradeEngineService.createProduct(product);
    //        response.setResponse("created " + request.getCommercialName() + " with price " + request.getPrice());
    //        logger.info("createProduct CALLED");
    //        return response;
    //    }
    //
    //    public void setTradeEngineService(TradeEngineService tradeEngineService)
    //    {
    //        this.tradeEngineService = tradeEngineService;
    //    }
}
