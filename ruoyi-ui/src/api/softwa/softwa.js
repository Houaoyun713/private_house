import request from '@/utils/request'

// 查询软件著作权列表
export function listSoftwa(query) {
  return request({
    url: '/softwa/softwa/list',
    method: 'get',
    params: query
  })
}

// 查询软件著作权详细
export function getSoftwa(id) {
  return request({
    url: '/softwa/softwa/' + id,
    method: 'get'
  })
}

// 新增软件著作权
export function addSoftwa(data) {
  return request({
    url: '/softwa/softwa',
    method: 'post',
    data: data
  })
}

// 修改软件著作权
export function updateSoftwa(data) {
  return request({
    url: '/softwa/softwa',
    method: 'put',
    data: data
  })
}

// 删除软件著作权
export function delSoftwa(id) {
  return request({
    url: '/softwa/softwa/' + id,
    method: 'delete'
  })
}
