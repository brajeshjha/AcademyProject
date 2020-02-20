


<jsp:include page="Welcome.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<style type="text/css">

.table{
width:70%;
}

</style>
</head>
<h1> <%=request.getParameter("param1")%> Objectives</h1>
<!-- <%=request.getAttribute("sname") %> -->
<br>
<br>

  
<form action="AddObjective.jsp" method="post" >
<input type="hidden" name="sname" value=<%=request.getAttribute("sname") %>>
<input type="hidden" name="sid" value=<%=request.getAttribute("sid") %>>
<input type="hidden" value="Add"  class="btn btn-success .btn-sm"/>
</form>



<button type="button" class="btn btn-link"  
    data-toggle="modal" data-target="#addform">Add</button>
    
    
    <div class="modal modal-centered" id="addform">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class ="modal-header">
        <!--<h4 class="modal-title"><%=request.getAttribute("sname") %></h4>-->
        <h4 class="modal-title"><%=request.getParameter("param1")%></h4>
      </div>
      <div class="modal-body mx-3">
        
          <form action="ObjectiveController" method="post">
          <div class="md-form mb-5">
<div class="form-group">
<input type="hidden" name="act" value="addobj">
<!-- <input type="hidden" name="param2" value=<%=request.getAttribute("sid") %>> -->
<!-- <input type="hidden" name="param1" value=<%=request.getAttribute("sname") %>> -->
<input type="hidden" name="param2" value=<%=request.getParameter("param2") %>>
<input type="hidden" name="param1" value=<%=request.getParameter("param1") %>>
<label class="form-control-label">Name:</label>
<input type="text" name="Name" id="Name" class="form-control"><br><br>
<label class="form-control-label">Description:</label>
<textarea rows="5" cols="10" name="Description" class="form-control"></textarea><br><br>

<label class="form-control-label">Level:</label>
<select name="Level" class="form-control">
<option value="Beginner">Beginner</option>
<option value="Intermediate">Intermediate</option>
<option value="Expert">Expert</option>
</select>


</div>

<br><br>
<input type="submit" value="Add" class="btn btn-primary">
</div>

</form>
       
      <div class ="modal-footer">
      <button type="button" class="btn btn-danger" data-dismiss="modal">
      Close
      </button>
      </div>
       </div>
    </div>
</div>
</div>












<div align="center">
<table class ="table">
<tr><th>Name</th><th>Level</th><th colspan="2">Actions</th></tr>
<c:forEach items="${list}" var="data" varStatus="vs">
<tr><td>${data.name}</td><td>${data.level}</td>
<td>
<form action="ObjectiveController" method="post">
    <input type="hidden" name="id" value="${data.id}" >
    <input type="hidden" name="param2" value=<%=request.getParameter("param2") %>>
    <input type="hidden" name="param1" value=<%=request.getParameter("param1") %>>    
    <input type="hidden" name="act" value="rmvObj">
    <button type="submit" class="btn btn-link">Remove</button>
</form>
</td>
<td align="left">
    <button type="button" class="btn btn-link"  
    data-toggle="modal" data-target="#editform${vs.index}">Edit</button>
    
    
    <div class="modal modal-centered" id="editform${vs.index}">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class ="modal-header">
        <h4 class="modal-title">Update ${data.name}</h4>
      </div>
      <div class="modal-body mx-3">
       
          <form action="ObjectiveController" method="post">
           <div class="md-form mb-5">
    <input type="hidden" name="id" value="${data.id}" />
    <input type="hidden" name="act" value="updObj" />
    <input type="hidden" name="param2" value=<%=request.getParameter("param2") %>>
    <input type="hidden" name="param1" value=<%=request.getParameter("param1") %>>
    <input type="hidden" name="name" value="${data.name}"/>
    <input type="hidden" name="desc" value="${data.description}"/>
    <input type="hidden" name="level" value="${data.level}"/>
    <label class="form-control-label">Name:</label>
    <input class="form-control" type="text" name="obname" placeholder="${data.name}" />
    <label class="form-control-label">Description:</label>
    <input class="form-control" type="text" name="obdesc" placeholder="${data.description}" />
    <label class="form-control-label">Level:</label>
    <select name="oblevel" class="form-control">
    <option value="" disabled selected hidden>${data.level}</option>
    <option value="Beginner">Beginner</option>
    <option value="Intermediate">Intermediate</option>
    <option value="Expert">Expert</option>
    </select>
    <br><br>
    <button type="submit" class="btn btn-success">Update</button>
    </div>
</form>
       
      <div class ="modal-footer">
      <button type="button" class="btn btn-danger" data-dismiss="modal">
      Close
      </button>
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