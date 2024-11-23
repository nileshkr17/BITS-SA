from service import ProductService
class ProductPresentation:
	def __init__(self):
		self.product_service = ProductService()

	def show_products(self):
		"""Display all products in a user-friendly format."""
		products = self.product_service.get_product_list()
		print("Available Products:")
		for product in products:
			print(f"ID: {product['id']}, Name: {product['name']}, Price: ${product['price']}")

# Run the application
if __name__ == "__main__":
	ProductPresentation().show_products()