<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="v"%>
</head>
<body>

	<form action="add " method="POST">
		Make: <input type="text" value="${values['make']}" class=""
			name="make">
		<v:if test="${errors.contains('make')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> Model: <input type="text" value="${values['model']}" class=""
			name="model">
		<v:if test="${errors.contains('model')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> Year: <input type="number" max="9999999"
			value="${values['year']}" class="" name="year">
		<v:if test="${errors.contains('year')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> Price: <input type="number" max="9999999"
			value="${values['price']}" class="" name="price">
		<v:if test="${errors.contains('price')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> License_number: <input type="text"
			value="${values['license_number']}" class="" name="license_number">
		<v:if test="${errors.contains('license_number')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> Colour: <input type="text" value="${values['colour']}"
			class="" name="colour">
		<v:if test="${errors.contains('colour')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> Number_doors: <input type="number" max="9999999"
			value="${values['number_doors']}" class="" name="number_doors">
		<v:if test="${errors.contains('number_doors')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> Transmission: <input type="text"
			value="${values['transmission']}" class="" name="transmission">
		<v:if test="${errors.contains('transmission')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> Mileage: <input type="number" max="9999999"
			value="${values['mileage']}" class="" name="mileage">
		<v:if test="${errors.contains('mileage')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> Fuel_type: <input type="text" value="${values['fuel_type']}"
			class="" name="fuel_type">
		<v:if test="${errors.contains('fuel_type')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> Engine_size: <input type="number" max="9999999"
			value="${values['enigne_size']}" class="" name="engine_size">
		<v:if test="${errors.contains('engine_size')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> Body_style: <input type="text" value="${values['body_style']}"
			class="" name="body_style">
		<v:if test="${errors.contains('body_style')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> Condition: <input type="text" value="${values['condition']}"
			class="" name="condition">
		<v:if test="${errors.contains('condition')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> Notes: <input type="text" value="${values['notes']}" class=""
			name="notes">
		<v:if test="${errors.contains('notes')}">
			<br />
			<span class="label label-danger">Cannot be empty</span>
		</v:if>
		<br /> <input type="submit" value="Add" />
	</form>
	<a href="http://localhost:8080/">home</a>

</body>
</html>