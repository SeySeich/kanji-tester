$( document ).ready( function( ) {
	
	$.ajax( {
		url: '/kanji-tester/test/word/errors',
		type: 'GET',
		dataType: 'json',
		contentType: "application/json; charset=utf-8",
		success: function( data ) {
			var score = $( '#score' );
			score.text( data.correctWordsAmount + '/' + data.totalWordsAmount );
			
			if ( data.result )
				$( '.error-words' ).hide( );
			else
			{
				var prototype = $( '.prototype-row' );
				var lastRow = prototype;
				
				$.each( data.words, function( ) {
					var newRow = prototype.clone( true );
					newRow.attr( 'style', '' );
					newRow.find( '.word_kanji' ).text( this.kanji );
					newRow.find( '.word_hiragana' ).text( this.hiragana );
					newRow.find( '.word_meanings' ).text( this.meanings.join( '; ' ) );
					lastRow.after( newRow );
					lastRow = newRow;
				} );
			}
		},
		error: function( jqxhr, statusText, errorThrown ) {
			alert( 'Не удалось получить перечень ошибок!' );
		}
	});
	
});