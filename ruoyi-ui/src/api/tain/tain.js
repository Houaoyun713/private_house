import request from '@/utils/request'

// 查询公司维护列表
export function listTain(query) {
  return request({
    url: '/tain/tain/list',
    method: 'get',
    params: query
  })
}

// 查询公司维护详细
export function getTain(id) {
  return request({
    url: '/tain/tain/' + id,
    method: 'get'
  })
}

// 新增公司维护
export function addTain(data) {
  return request({
    url: '/tain/tain',
    method: 'post',
    data: data
  })
}

// 修改公司维护
export function updateTain(data) {
  return request({
    url: '/tain/tain',
    method: 'put',
    data: data
  })
}

// 删除公司维护
export function delTain(id) {
  return request({
    url: '/tain/tain/' + id,
    method: 'delete'
  })
}
