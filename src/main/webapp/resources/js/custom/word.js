var fillData = function( )
{
	$.ajax( { 
		url: '/kanji-tester/test/word',
		type: 'GET',
		success: function( data ) {
			var word = data.word;
			$( '#wordId' ).val( word.id );
			$( '.kanji' ).text( word.kanji );
			$( '.hiragana' ).text( word.hiragana );
			var length = word.meanings.length;
			var index = 1;
			while ( index <= 8 )
			{
				var span = $( '#meaning' + index );
				if ( index <= length )
				{
					removeStyle( span );
					span.prev( ).prop( 'checked', false );
					span.text( word.meanings[ index - 1 ] );
					span.closest( '.meaning-holder' ).show( );
				}
				else
					span.closest( '.meaning-holder' ).hide( );
				index++;
			}
		},
		error: function( jqxhr, textStatus, errorThrown ) {
			alert( 'Фигня какая-то' );
		}
	} );
	
	return false;
};

var colorElement = function( element, color, bgColor )
{
	element.attr( 'style', 'background-color: ' + bgColor + '; color: ' + color );
};

var colorCorrect = function( element )
{
	colorElement(element, 'white', 'green' );
};

var colorIncorrect = function( element )
{
	colorElement( element, 'white', 'red' );
};

var removeStyle = function( element )
{
	element.attr( 'style', '' );
}

$( document ).ready( function( ) { 
	
	fillData( );
	
	$( '#check' ).click( function( ) { 
		var _id = $( '#wordId' ).val( );
		var _meanings = [ ];
		var anyChecked = false;
		for ( var i = 1; i <= 8; i++ )
		{
			var meaning = $( '#meaning' + i );
			if ( meaning.is( ':visible' ) && meaning.prev( ).is( ':checked' ) )
			{
				_meanings.push( meaning.text( ) );
				anyChecked = true;
			}
		}
		
		if ( ! anyChecked )
		{
			alert( 'Не выбрано ни одного значения!' );
			
			return false;
		}
		
		var _word = { id: _id, meanings: _meanings };
		
		$.ajax( { 
			url: '/kanji-tester/test/word/check',
			type: 'POST',
			data: JSON.stringify({ word: _word } ),
			dataType: 'json',
			contentType: "application/json; charset=utf-8",
			success: function( data ) {
				if ( data.result )
				{
					if ( ! data.end )
					{
						fillData( );
					}
					else
					{
						document.location.href = '/kanji-tester/test/pages/word/result';
					}
				}
				else
				{
					var word = data.word;
					var corrects = word.correctMeanings;
					var incorrects = word.incorrectMeanings;
					for ( var i = 1; i <= 8; i++ )
					{
						var span = $( '#meaning' + i );
						span.prev( ).prop( 'checked', false );
						var meaning = span.text( );
						if ( jQuery.inArray( meaning, corrects ) >= 0 )
							colorCorrect( span );
						else if ( jQuery.inArray( meaning, incorrects ) >= 0 )
							colorIncorrect( span );
						else 
							removeStyle( span );
					}
				}
			},
			error: function( jqxhr, textStatus, errorThrown ) {
				alert( 'Фигня!' );
			}
		} );
		
		return false;
	});
});