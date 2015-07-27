app.controller('bookController', [ 'bookService', function(bookService) {
	var me = this;
	
	me.books = bookService.books.query();
	
	me.books2 = bookService.books2.query();
} ]);
