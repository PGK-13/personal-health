document.addEventListener('DOMContentLoaded', () => {
    const navLinks = document.getElementById('nav-links');
    const mainContent = document.getElementById('main-content');
    const token = localStorage.getItem('token');

    if (token) {
        // 用户已登录
        navLinks.innerHTML = `
            <li><a href="#" id="logout">退出登录</a></li>
        `;
        mainContent.innerHTML = `
            <h2>欢迎回来！</h2>
            <p>您可以在此管理您的健康数据。</p>
            <button id="view-data">查看体征数据</button>
        `;

        document.getElementById('logout').addEventListener('click', () => {
            localStorage.removeItem('token');
            location.reload();
        });

        document.getElementById('view-data').addEventListener('click', () => {
            fetch('/api/vitalsigns', {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            })
                .then(response => response.json())
                .then(data => {
                    // 在此处理获取到的体征数据
                    console.log(data);
                })
                .catch(error => console.error('获取体征数据失败：', error));
        });
    } else {
        // 用户未登录
        navLinks.innerHTML = `
            <li><a href="/login.html">登录</a></li>
            <li><a href="/register.html">注册</a></li>
        `;
        mainContent.innerHTML = `
            <h2>欢迎来到个人健康数据管理系统</h2>
            <p>请登录或注册以管理您的健康数据。</p>
        `;
    }
});
