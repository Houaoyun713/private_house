import request from '@/utils/request'

// 查询课题维护列表
export function listMain(query) {
  return request({
    url: '/main/main/list',
    method: 'get',
    params: query
  })
}

// 查询课题维护详细
export function getMain(id) {
  return request({
    url: '/main/main/' + id,
    method: 'get'
  })
}

// 新增课题维护
export function addMain(data) {
  return request({
    url: '/main/main',
    method: 'post',
    data: data
  })
}

// 修改课题维护
export function updateMain(data) {
  return request({
    url: '/main/main',
    method: 'put',
    data: data
  })
}

// 删除课题维护
export function delMain(id) {
  return request({
    url: '/main/main/' + id,
    method: 'delete'
  })
}
