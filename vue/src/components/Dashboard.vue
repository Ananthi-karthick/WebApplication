<template>
<div id="app">
  <div class="container">
    <h1>Admin Dashboard</h1>
    <div class="row">
      <div class="col-md-4">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Total Users</h5>
            <p class="card-text">
              <span class="number">{{ totalUsers }}</span>
              <span class="delta" :class="{ 'increase': isDeltaPositive, 'decrease': !isDeltaPositive }">{{ delta }}</span>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

</template>
<script>
export default {
    name:'Dashboard',
    data() {
    return {
      totalUsers: 50,
      lastTotalUsers: 70,
      delta:10
    };
  },
}
</script>
<style scoped>
@keyframes delta-increase {
  from {
    transform: translateY(0);
    opacity: 0;
  }
  to {
    transform: translateY(-10px);
    opacity: 1;
  }
}

@keyframes delta-decrease {
  from {
    transform: translateY(0);
    opacity: 0;
  }
  to {
    transform: translateY(10px);
    opacity: 1;
  }
}

.delta {
  font-size: 14px;
  margin-left: 10px;
}

.increase {
  color: green;
  animation: delta-increase 0.3s ease-out;
}

.decrease {
  color: red;
  animation: delta-decrease 0.3s ease-out;
}

</style>