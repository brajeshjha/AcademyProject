
<jsp:include page="navbar.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<style type="text/css">
.table {
	width: 70%;
}

.modal {
	align: center;
}

.addstack {
	width: 30%;
	align: center;
}
</style>
</head>
<h1>Stacks</h1>
<br>
<br>
<div class="addstack">
	<form action="StackServlet" method="post">
		<input type="hidden" name="act" value="addStack">
		<input class="form-control" type="text" name="name" placeholder="Name" /><br>
		<input type="submit" value="Add Stack" id="addStackid"
			class="btn btn-success btn-sm" />
	</form>
</div>

<br>
<br>




<div align="center">
	<table class="table">
		<col style="width: 20%">
		<col style="width: 20%">
		<col style="width: 10%">
		<col style="width: 10%">
		<tr>
			<th>Name</th>
			<th>Objectives</th>
			<th colspan="2" align="right">Actions</th>
		</tr>
		<c:forEach items="${List}" var="data" varStatus="vs">
			
			<tr>
				<td>${data.name}</td>
				<td>
					<form action="ObjectiveServlet" method="post">
						<input type="hidden" name="act" value="fetchAllObjective">
						<input type="hidden" name="param1" value="${data.name}">
						<input type="hidden" name="param2" value="${data.id}">
						<button type="submit" class="btn btn-link">${data.count}</button>
					</form> 

				</td>

				<td>
					<form action="StackServlet" method="post">
						<input type="hidden" name="act" value="removeStack">						
						<input type="hidden" name="param1" value="${data.name}">
						<input type="hidden" name="param2" value="${data.id}">
						<button type="submit" class="btn btn-link">Remove</button>
					</form>
				</td>
				<td align="left">
					<button type="button" class="btn btn-link" data-toggle="modal"
						data-target="#editform${vs.index}">Edit</button>

					<!-- Popup Form(modal) to update stack -->
					<div class="modal modal-centered" id="editform${vs.index}">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">Edit ${data.name}</h4>
								</div>
								<div class="modal-body">
									<div class="md-form mb-5">
										<form action="StackServlet" method="post">
											<input type="hidden" name="act" value="updateStack">
											<input type="hidden" name="param1" value="${data.name}">
											<input type="hidden" name="param2" value="${data.id}">
											<label class="form-control-label">Name :</label> 
											<input class="form-control" type="text" name="sname" placeholder="${data.name}"> 
											<br>
											<button type="submit" class="btn btn-success">Update</button>
										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-danger"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>


<jsp:include page="footer.jsp" />