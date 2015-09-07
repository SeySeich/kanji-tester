var fillData = function( ) {
	$.ajax({
		url: '/kanji-tester/test/kanji',
		type: 'GET',
		success: function( data ) {
			var kanji = data.kanji;
			$( '.kanji-character' ).text( kanji.value );
			
			var meanings = kanji.meanings;
			var i = 1;
			while ( i <= 8 )
			{
				if ( i <= meanings.length )
					$( '#meaning' + i ).text( meanings[ i - 1 ] );
				else
				{
					$( '#meaning' + i ).closest( '.meaning-holder' ).hide( );
				}
				i++;
			}
			
			var kunRowPrototype = $( '#kun-row-prototype' );
			var kunRow = kunRowPrototype.clone( true ); // $( '#kun-row-1' );
			kunRow.attr( 'id', 'kun-row-1' );
			kunRow.attr( 'style', '' );
			kunRowPrototype.after( kunRow );
			var kunReadingSelect = $( '.kun-reading' );
			var kunMeaningSelect = $( '.kun-meaning' );
			$( '#max-kun-table-size' ).val( kanji.kunReadings.length );
			$.each( kanji.kunReadings, function( key, value ) { 
				kunReadingSelect.append( $( '<option></option>' ).text( value ) );
			} );
			$.each( kanji.kunMeanings, function( key, value ) { 
				kunMeaningSelect.append( $( '<option></option>' ).text( value ) );
			} );
			
			var onRowPrototype = $( '#on-row-prototype' );
			var onReadingSelect = $( '.on-reading' );
			$.each( kanji.ons, function( index, value ) {
				onReadingSelect.append( $( '<option></option>' ).text( value ) );
			} );
			var onRow = onRowPrototype.clone( true );
			onRow.attr( 'id', 'on-row-1' );
			onRow.attr( 'style', '' );
			onRowPrototype.after( onRow );
			$( '#max-on-table-size' ).val( kanji.ons.length );
		},
		error: function( jqxhr, textStatus, errorThrown ) {
			alert( 'Произошла ошибка!' );
		}
	});
}

$( document ).ready( function( ) {
	
	fillData( );
	
	$( '#add-kun' ).click( function( ) {
		var kunTableSize = parseInt( $( '#kun-table-size' ).val( ) );
		var row = $( '#kun-row-prototype' );
		kunTableSize++;
		var clone = row.clone( true );
		clone.attr( 'style', '' );
		clone.attr( 'id', 'kun-row-' + kunTableSize );
		row.after( clone );
		$( '#kun-table-size' ).val( kunTableSize );
		
		var maxSize = $( '#max-kun-table-size' ).val( );
		if ( kunTableSize == maxSize )
			$( "#add-kun" ).prop( 'disabled', true );
		
		return false;
	});
	
	$( '.remove-kun' ).click( function( ) {
		var kunTableSize = parseInt( $( '#kun-table-size' ).val( ) ) - 1;
		var row = $( this ).closest( '.row' );
		
		if ( kunTableSize != 0  )
		{
			$( this ).closest( '.row' ).remove( );
			$( '#kun-table-size' ).val( kunTableSize )
			$( "#add-kun" ).prop( 'disabled', false );
		}
	});
	
	$( '#add-on' ).click( function( ) {
		var onTableSize = parseInt( $( '#on-table-size' ).val( ) );
		var row = $( '#on-row-prototype' );
		onTableSize++;
		var clone = row.clone( true );
		clone.attr( 'style', '' );
		clone.attr( 'id', 'on-row-' + onTableSize );
		row.after( clone );
		$( '#on-table-size' ).val( onTableSize );
		
		var maxSize = $( '#max-on-table-size' ).val( );
		if ( onTableSize == maxSize )
			$( "#add-on" ).prop( 'disabled', true );
		
		return false;
	} );
	
	$( '.remove-on' ).click( function( ) {
		var onTableSize = parseInt( $( '#on-table-size' ).val( ) ) - 1;
		var row = $( this ).closest( '.row' );
		
		if ( onTableSize != 0  )
		{
			$( this ).closest( '.row' ).remove( );
			$( '#on-table-size' ).val( onTableSize )
			$( "#add-on" ).prop( 'disabled', false );
		}
	});
} );
