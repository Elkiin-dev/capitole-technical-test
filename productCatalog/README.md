# Technical-Test

Technical test for Capitole

This application provides a catalog of products by applying discounts.

## Index

- Requirements
- Database model
- How to run it
- Endpoints
- Events

## Requirements:

- Java (OpenJDK 17.0.13)

## Database model:

![aa](https://i.imgur.com/csNwggt.png)

## How to run it:

### Run Application:

```
gradlew run
```

### Run unitTests:

```
gradlew test
```


## Endpoints

GET - /products

#### Parameters

> | name        | type | description                             | exemple      |
> | ----------- |------|-----------------------------------------|--------------|
> | sorted   | String | Field to sort                           | Category     |
> | category | String | Used to filter product list by category | Toys & Games |
> | page    | int  | Number of pages (start at 0)            | 0            |
> | size | int  | Number of elements in page              | 3            |

#### Responses
> | Field         | Type  | Description                                                                    | Example                           |
> |-------------------|----------|------------------------------------------------------------------------------------|---------------------------------------|
> | sku             | object | Object containing SKU details.                                                    | { "value": "SKU0024" } |
> | price           | float  | Price of the product before applying promotions.                                   | 30.0                                |
> | description     | string | Description of the product.                                                       | "Wooden Chess Set with Folding Board" |
> | category        | string | Category of the product.                                                          | "TOYS_GAMES"                       |
> | discountApplied | float  | Discount applied to the product, if any.                                          | null                                |

## Events

Currently no event is consumed or produced.