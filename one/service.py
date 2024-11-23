from data import ProductData

class ProductService:
    def __init__(self):
        self.product_data = ProductData()

    def get_product_list(self):
        """Retrieve product list with business logic applied."""
        return self.product_data.get_all_products()
