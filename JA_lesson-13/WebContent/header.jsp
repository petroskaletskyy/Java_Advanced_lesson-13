  
<link rel="stylesheet" href="css/header.css">



  <div id="wrapper" class="animate">
    <nav class="navbar header-top fixed-top navbar-expand-lg  navbar-dark bg-dark">
      <span class="navbar-toggler-icon leftmenutrigger"></span>
      <a class="navbar-brand" href="#">Book Store</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav animate side-nav">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/cabinet.jsp">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item admin-addbook-option">
            <a class="nav-link" href="${pageContext.request.contextPath}/addBook.jsp">add Book</a>
          </li>
          <li class="nav-item user-bucket-option">
            <a class="nav-link" href="${pageContext.request.contextPath}/bucket.jsp">Bucket</a>
          </li>
        </ul>
        <ul class="navbar-nav ml-md-auto d-md-flex">
          <li class="nav-item">
            <button class="nav-link logout">Log Out</button>
          </li>
        </ul>
      </div>
    </nav>
  
  </div>
  