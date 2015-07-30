app.controller('bookController', [ 'bookService', function(bookService) {
	var me = this;
	
	me.books = bookService.book.query();
} ]);
