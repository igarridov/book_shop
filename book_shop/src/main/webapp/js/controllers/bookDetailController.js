app.controller('bookDetailController', [ 'bookService', '$routeParams', function(bookService, $routeParams) {
	var me = this;
	me.idbook = $routeParams.bookId;
	me.book = {};
	me.authors = [];
	me.reviews = [];
	
	me.book = bookService.book.get({idbook: me.idbook}, function(book) {

		// Recuperar las reviews y authores despues de recuerar el libro
		me.authors = bookService.author.query({idbook: book.idbook});
		me.reviews = bookService.review.query({idbook: book.idbook});
		
	});
	
} ]);
